package Dictionary;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {


    public Map<String, Object> memberValuesDictionary(Object o) throws IllegalAccessException {
        Class aclass = o.getClass();
        Field[] fields = aclass.getDeclaredFields();
        Map<String, Object> newMap = new HashMap<>();

//        for(Field f : fields){
//            try {
//                f.setAccessible(true);
//            } catch (IllegalArgumentException e){
//                e.printStackTrace();
//            }
//
//        }


        for (int i = 0; i < fields.length; i++) {
            newMap.put(fields[i].getName(), fields[i].get(o));
        }
        return newMap;
    }

    public static String getterName(String fieldName){
        StringBuilder builder = new StringBuilder(fieldName.length() + 3);
        builder.append("get");
        builder.append(fieldName);
        builder.setCharAt(3, Character.toUpperCase(builder.charAt(3)));
        return builder.toString();
    }

    public static String setterName(String fieldName){
        StringBuilder builder = new StringBuilder(fieldName.length() + 3);
        builder.append("set");
        builder.append(fieldName);
        builder.setCharAt(3, Character.toUpperCase(builder.charAt(3)));
        return builder.toString();
    }

    public static Method getter(Field field) throws NoSuchMethodException {
           String fieldName = getterName(field.getName());
           return field.getDeclaringClass().getMethod(fieldName);
    }

    public static Method setter(Field field) throws NoSuchMethodException {
        String fieldName = setterName(field.getName());
        return field.getDeclaringClass().getMethod(fieldName, field.getType());
    }

    public static Map<String, FieldInfo> memberInfoDictionary(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();
        Map<String, FieldInfo> newMap = new HashMap<>();
        for (Field f : fields) {
            FieldInfo info = new FieldInfo();
            info.field = f;
            try {
                info.getter = getter(f);
            } catch (NoSuchMethodException e) {
                info.getter = null;
            }
            try {
                info.setter = setter(f);
            }
            catch (NoSuchMethodException e){
                info.setter=null;
            }
            newMap.put(f.getName(), info);
        }
        return newMap;
    }


    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        Clothing dress = new Clothing("dress", 38, "blue", 200.00);
        Clothing blouse = new Clothing("blouse", 36, "green", 60.50);
        Clothing blazer = new Clothing("blazer", 40, "yellow", 150.00);
        Clothing troursers = new Clothing("trousers", 42, "navy", 130.05);

//        try {
//            dictionary.memberValuesDictionary(dress);
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        try {
            Map<String, FieldInfo> fieldsInfo = memberInfoDictionary(dress);
            fieldsInfo.get("name").setter.invoke(dress, "shoes");
            System.out.println(dress);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

//Napisz funkcję
//Map<String, Object> membersDictionary(Object o)
//która dostaje obiekt, wyciąga z niego wszystkie pola, i tworzy mapę [nazwa pola] -> [wartość pola]
//Kluczem mapy są nazwy - stringi, wartościami Object, dlatego że typy pól mogą być różne, a chcemy
//zapisać wszystko w jednej mapie.