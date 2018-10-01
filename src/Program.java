import javafx.scene.Scene;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.activation.Activator;
import java.util.Scanner;

public class Program {

    public static class Person {
        public String name;
        public String surname;
        public int age;

        public Person(String name, String surname, int age) {
            this.name = name;
            this.surname = surname;
            this.age = age;
        }

        public void getOlder() {
            ++age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException, ClassNotFoundException {

        System.out.println(Person.class.getName());

        Person p = new Person("Martin", "Smith", 34);
//        Field[] fields = c.getDeclaredFields();
//        Method[] methods = c.getMethods();


        Scanner scanner = new Scanner(System.in);

        String className = scanner.nextLine();

        Class personClass = Class.forName(className);
        Constructor ctor = personClass.getConstructor(String.class, String.class, int.class);

        String name = scanner.nextLine();
        String surname = scanner.nextLine();
        int age = scanner.nextInt();

        Object newPerson = ctor.newInstance(name, surname, age);

        System.out.println(newPerson);


//        String fieldName = scanner.nextLine();
//        String fieldValue = scanner.nextLine();
//
//        try {
//            c.getField(fieldName).set(p, fieldValue);
//        } catch (IllegalAccessException | NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//
////        try {
////            fields[0].set(p, "Joe");
////            fields[1].set(p, 9);
////            c.getField("age").set(p, 6);
////            methods[0].invoke(p);
////        } catch (IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
////            e.printStackTrace();
////        }
//
//
//        for (Field f : fields){
//            try {
//                //f.setAccessible(true);
//                System.out.println(f.get(p));
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
    }

}
