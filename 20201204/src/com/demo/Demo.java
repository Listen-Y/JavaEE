package com.demo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-04
 * Time: 19:03
 */
public class Demo {

    public static void main1(String[] args) {
        Map<String, String> map = new ConcurrentSkipListMap<>();
        String s = "hello";
        String s1 = "he" + new String("llo");
        System.out.println(s == s1);
    }

    public static void main2(String[] args) {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a);
        add(b);
        System.out.println(b);
    }

    private static void add(Byte b) {
        b = b++;
    }

    public static void main(String[] args) {
        exc();
    }

    private static void exc() {
        try {
            throw new Exception();
        } catch (FileNotFoundException e) {
            System.out.println("fileNot");
        } catch (IOException e) {
            System.out.println("IOEXCEption");
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }
}
