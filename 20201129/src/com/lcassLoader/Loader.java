package com.lcassLoader;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-29
 * Time: 11:04
 */
public class Loader {

    public static void main(String[] args) {
        Loader loader = new Loader();

        ClassLoader classLoader = loader.getClass().getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        System.out.println(parent1.getParent());
    }
}
