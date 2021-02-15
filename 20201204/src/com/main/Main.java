package com.main;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-04
 * Time: 19:43
 */
public class Main {

    public static void main1(String[] args) {
        /*System.out.println(Arrays.toString(getGray(3)));*/

        int[] ab = new int[] {1,2, 1};
        /*swap(ab);*/
        System.out.println(one(ab));
        System.out.println(Arrays.toString(ab));
    }

    public static String[] getGray(int n) {
        // write code here
        String[] results = null;
        if (n == 1) {
            results = new String[] {"0", "1"};
            return results;
        } else {
            String[] temp = getGray(n - 1);
            results = new String[temp.length << 1];
            int count = 0;
            for( int i = 0; i < temp.length; i++) {
                results[count++] = "0" + temp[i];
            }
            for( int i = temp.length - 1; i >= 0; i--) {
                results[count++] = "1" + temp[i];
            }
            return results;
        }
    }

    public static void swap(int[] ab) {
        ab[0] = ab[0] ^ ab[1];
        ab[1] = ab[0] ^ ab[1];
        ab[0] = ab[0] ^ ab[1];
    }

    public static int one (int[] ab) {
        int ret = ab[0];
        for (int i = 1; i < ab.length; i++) {
            ret = ret ^ ab[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        new Thread(() -> {

        }).start();
    }
}
