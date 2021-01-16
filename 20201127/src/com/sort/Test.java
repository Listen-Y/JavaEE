package com.sort;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-27
 * Time: 12:39
 */
public class Test {

    public static void main(String[] args) {
/*
        Demo demo = new Demo();
        int[] array = new int[] {9,8,7,6,5,4,3,2,1};
        demo.quickSort(array);
        System.out.println(Arrays.toString(array));
        int[] array1 = new int[] {9,8,7,6,5,4,3,2,1};
        demo.mergeSort(array1);
        System.out.println(Arrays.toString(array1));
*/


        int[][] nums = new int[][] {{1,2,3,4}, {4,5,6,7}, {1,2,3,4}, {4,5,6,7}};
        printNN(nums);

    }

    public static void printNN(int[][] nums) {
        int length = nums[0].length;
        int row = 0;
        int col = 0;
        int count = 0;
        while (length > 1) {
            //输出第一行
            while (col < length + col ) {
                System.out.println(nums[row][col]);
                 col++;
            }
            //输出最右边
            col--;
            while (row < length + row) {
                System.out.println(nums[row][col]);
                row++;
            }
            row--;
            //输出最下边
            while (col > length + col) {
                System.out.println(nums[row][col]);
                col--;
            }
            //输出最左边
            while (row > length - 1) {
                System.out.println(nums[row][col]);
                row--;
            }
            length /= 2;
            count++;
            row = count;
            col = count;
        }

    }
}
