package com.lcassLoader;

import java.util.*;
public class Main {
    public static  void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num1 = scan.nextInt();
            int num2 = scan.nextInt();
            int ret = Math.max(num1, num2);
            while (ret % num1 != 0 && ret % num2 != 0) {
                ret++;
            }
            System.out.println(ret);
        }
    }


}