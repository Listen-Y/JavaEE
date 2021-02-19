package com.demo;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-06
 * Time: 19:11
 */
public class Print {

    static boolean out(char c) {
        System.out.println(c);
        return true;
    }

    public static void main1(String[] args) {
        int i = 0;
        for (out('A'); out('B') && (i < 2); out('C')) {
            i++;
            out('D');
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            BigInteger num = new BigInteger(scan.next());
            num = num.add(new BigInteger(scan.next()));
            System.out.println(num.toString());
        }
    }
}
