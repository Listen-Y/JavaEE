package com.solution;

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int num = scan.nextInt();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                list.add(i);
            }
            int index = 0;
            while (list.size() > 1) {
                index = (index + 2) % list.size();
                list.remove(index);
            }
            System.out.println(list.get(0));
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] numsStr = s.split(" ");
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
            for (int i = 0; i < numsStr.length - 1; i++) {
                priorityQueue.add(Integer.parseInt(numsStr[i]));
            }
            int count = Integer.parseInt(numsStr[numsStr.length - 1]);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < count; i++) {
                builder.append(priorityQueue.poll()).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }

    public static void main3(String[] args) {
/*        int[][] nums = new int[][] {{1,2,3,4}, {5,6,7,8}, {1,2,3,4}, {5,6,7,8}};
        printJZZ(nums, 0, nums.length - 1);
        ((Main)null).printJZ(nums, 0, nums.length - 1);*/
/*        int i = 1;
        Integer integer = new Integer(1);
        System.out.println(i==integer);
        System.out.println(integer.equals(i));*/
        String s = "sss";
        s.toUpperCase();
    }

    public static void printJZ(int[][] nums, int start, int end) {
        if (start > end || end < 0) {
            return;
        }
        //输出第一行
        for (int i = 0; i <= end; i++) {
            System.out.println(nums[start][i]);
        }
        //输出最后一列
        for (int i = start +1; i <= end; i++) {
            System.out.println(nums[i][end]);
        }
        //输出最下面一行
        for (int i = end - 1; i >=  start; i--) {
            System.out.println(nums[end][i]);
        }
        //输出第一列
        for (int i = end - 1; i > start; i--) {
            System.out.println(nums[i][start]);
        }
        //递归调用
        printJZ(nums, start + 1, end - 1);
    }

    public static void printJZZ(int[][] nums, int start, int end) {
        if (start > end || end < 0) {
            return;
        }
        for (int i = start; i <= end; i++) {
            System.out.println(nums[start][i]);
        }
        for (int i = start + 1; i <= end; i++) {
            System.out.println(nums[i][end]);
        }
        for (int i = end - 1; i > start; i--) {
            System.out.println(nums[end][i]);
        }
        for (int i = end; i > start; i--) {
            System.out.println(nums[i][start]);
        }
        printJZZ(nums, start + 1, end - 1);
    }

    public static void main4(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            StringBuilder buffer = new StringBuilder(line);
            buffer.reverse();
            System.out.println(buffer.toString());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int ret = 0;
            for (int i = num; i >= 5; i--) {
                int temp = i;
                while (temp % 5 == 0) {
                    ret++;
                    temp /= 5;
                }
            }
            System.out.println(ret);
        }
    }


}