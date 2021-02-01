package com.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 17:16
 */
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = new int[] {0,0,1,0,2,3,0,0};
        sort.sortIndex(array);
        System.out.println(Arrays.toString(array));
    }

    public void indexSort(int[] array) {
/*        if (array == null || array.length <= 1) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                temp++;
            } else if (temp != 0) {
                array[i - temp] = array[i];
                array[i] = 0;
            }
        }*/
    }

    public void sortIndex(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count++;
            } else {
                if (count != 0) {
                    array[i - count] = array[i];
                    array[i] = 0;
                }
            }
        }
    }
}
