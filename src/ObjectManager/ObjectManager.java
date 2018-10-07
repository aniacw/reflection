package ObjectManager;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Scanner;

public class ObjectManager {

    private Object object;

    Class aClass = object.getClass();
    Field[] field = aClass.getFields();
    int i = 0;
    String fieldName = field[i].getName();

    public ObjectManager(Object object) {
        this.object = object;
    }

    //set - ustawia pole o nazwie na wartość
    public void set(String fieldName, Object value) {
        for (Field f : field)
            if (fieldName.equals(f.getName())) {
                try {
                    f.set(f.getName(), value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
    }

    //get - pobiera wartość pola o nazwie
    Object fieldValue = null;

    public Object get(String fieldName) {
//        for (Field f : field) {
//            if (fieldName.equals(f.getName())) {
//                fieldValue = (Object) f[];
//            }
//        }
        for (int i = 0; i < field.length; i++) {
            if (fieldName.equals(field[i].getName()))
                fieldValue = (Object) field[i];
        }
        return fieldValue;
    }

//    public Map<String, Object> fieldDictionary() {
//    }

    //read - wczytuje z konsoli wartość pola o nazwie używając Scannera
    public void read(String fieldName) {
        Scanner scanner = new Scanner(System.in);
        String fieldValue = scanner.nextLine();

        for (Field f : field) {
            if (fieldName.equals(f.getName())) {
                try {
                    f.set(f.getName(), fieldValue);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //readAll - iteruje po wszystkich polach wyświetlając zapytanie w postaci nazwy pola i wczytuje wartość tak jak read
    public void readAll() {
        Scanner scanner = new Scanner(System.in);

        for (Field f : field) {
            System.out.println("Type the field name...");
            Object fieldValue = scanner.next();
            try {
                f.set(f.getName(), fieldValue);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    //print - wyświetla wartość pola o nazwie
    public void print(String fieldName) {
        for (Field f : field) {
            if (f.getName().equals(fieldName)) {
                try {
                    System.out.println("Value of " + fieldName + " is: " + f.get(object));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //printAll - wyświetla wszystkie nazwy pól i ich wartości (imituje domyślnie wygenerowaną metodę toString) różnica jest
// taka że będzie działać tak jak chcemy nawet dla obiektów które nie nadpisują metody toString albo obią to w niestandardowej formie.
    public void printAll() {
        for (Field f : field) {
            try {
                System.out.println("Value of " + fieldName + " is: " + f.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        Clothing pants = new Clothing("pants", 38, "blue", 100.00);
        ObjectManager o = new ObjectManager((Object) pants);
    }
}

//Napisz klasę ObjectManager, który będzie zajmował się zarządzaniem polami obiektu oraz tworzeniem
//obiektów, mając tylko informacje wyciągnięte mechanizmem refleksji.
//

//
//Tworzymy ten obiekt managera wrappując istniejący dowolny obiekt (przy okazji zagadnienie - wrapper
//do poczytania). Zaimplementować metody.
//set - ustawia pole o nazwie na wartość
//get - pobiera wartość pola o nazwie
//fieldDictionary - poprzednie zadanie
//read - wczytuje z konsoli wartość pola o nazwie używając Scannera
//readAll - iteruje po wszystkich polach wyświetlając zapytanie w postaci nazwy pola i wczytuje wartość tak jak read
//print - wyświetla wartość pola o nazwie
//printAll - wyświetla wszystkie nazwy pól i ich wartości (imituje domyślnie wygenerowaną metodę toString) różnica jest
// taka że będzie działać tak jak chcemy nawet dla obiektów które nie nadpisują metody toString albo obią to w niestandardowej formie.
//
//Odnośnie read i readAll - scanner ma parę podstawowych typów które może wczytywać metodami takimi jak nextInt,
// nextDouble itp... Wczytuj tylko te pola które może wczytać scanner, sprawdzając jaki ma typ i wywołując odpowiednią
// metodę wczytującą ze scannera. Jeśli Scanner nie ma
// możliwości wczytać wartości o danym type (bo np jest to jakaś nasza klasa) to wyrzucamy wyjątek (dobierz sobie jakiś odpowiedni).