package com.observer.test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-19
 * Time: 22:02
 */
public class Test {

    public static void main(String[] args) {
        Random random = new Random();
        boolean b = random.nextBoolean();
        System.out.println(b);
        Observable observable = new Observable();
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();
        List<String> list1 = Collections.synchronizedList(list);

    }
}
