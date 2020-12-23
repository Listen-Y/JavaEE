package com.webstudy.demo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-14
 * Time: 20:05
 */
public class Solution {

    @Test
    public void test() {
        int[] a = new int[] {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};

        System.out.println(findKth(a, 49, 24));
    }


    public int findKth(int[] a, int n, int K) {
        // write code here
        int[] nums = new int[K];
        if (K >= 0) System.arraycopy(a, 0, nums, 0, K);
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        for (int num : a) {
            findKathHelper(nums, num, K);
        }
        return nums[0];
    }

    private void findKathHelper(int[] nums, int num, int size) {
        if (num <= nums[0] || have(nums, num)) {
            return;
        } else {
            nums[0] = num;
        }
        int parent = 0;
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && nums[child + 1] < nums[child]) {
                child++;
            }
            if (nums[child] < nums[parent]) {
                int tmp = nums[child];
                nums[child] = nums[parent];
                nums[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }

    private boolean have(int[] nums, int num) {
        for (int key : nums
             ) {
            if (key == num) {
                return true;
            }
        }
        return false;
    }

    public String solve1 (String str) {
        // write code here
        StringBuilder builder = new StringBuilder(str);
        StringBuilder reverse = builder.reverse();
        return reverse.toString();
    }

    public String solve (String str) {
        // write code here
        if (str == null || str.length() <= 1) {
            return str;
        }
        int length = str.length();
        char[] chars = str.toCharArray();
        for (int i =  1; i <= length / 2; i++) {
            char tmp = chars[i - 1];
            chars[i - 1] = chars[length - i];
            chars[length - i] = tmp;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : chars
             ) {
            builder.append(c);
        }
        return builder.toString();
    }
}
