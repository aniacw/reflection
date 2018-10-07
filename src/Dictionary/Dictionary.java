package Dictionary;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {

    Map<String, Object> membersDictionary(Object o) throws IllegalAccessException {
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


    public static void main(String[] args) {

        Dictionary dictionary = new Dictionary();
        Clothing dress = new Clothing("dress", 38, "blue", 200.00);
        Clothing blouse = new Clothing("blouse", 36, "green", 60.50);
        Clothing blazer = new Clothing("blazer", 40, "yellow", 150.00);
        Clothing troursers = new Clothing("trousers", 42, "navy", 130.05);

        try {
            dictionary.membersDictionary(dress);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

//Napisz funkcję
//Map<String, Object> membersDictionary(Object o)
//która dostaje obiekt, wyciąga z niego wszystkie pola, i tworzy mapę [nazwa pola] -> [wartość pola]
//Kluczem mapy są nazwy - stringi, wartościami Object, dlatego że typy pól mogą być różne, a chcemy
//zapisać wszystko w jednej mapie.