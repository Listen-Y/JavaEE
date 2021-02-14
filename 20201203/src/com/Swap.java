package com;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-03
 * Time: 16:31
 */
public class Swap {

    public static void main(String[] args) {
        People people1 = new People("Listen", 20);
        People people2 = new People("Bike", 22);
        Class<? extends People> aClass = people1.getClass();
        Field[] fields = aClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(false);
            System.out.println(fields[i].toString());
        }
/*        System.out.println(people1);
        System.out.println(people2);
        swap(people1, people2);
        System.out.println("=====================");
        System.out.println(people1);
        System.out.println(people2);*/
    }

    private static void swap(People people1, People people2) {
        Class<? extends People> aClass = people1.getClass();
        Field[] fields = aClass.getFields();

        for (int i = 0; i < fields.length; i++) {

        }
    }
}

class People {
    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
