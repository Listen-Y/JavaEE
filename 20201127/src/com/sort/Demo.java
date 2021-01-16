package com.sort;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-27
 * Time: 12:29
 */
public class Demo {

    //快排
    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = paration(array, left, right);
        quickSortHelper(array, left, mid - 1);
        quickSortHelper(array, mid + 1, right);
    }

    private int paration(int[] array, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int baseVal = array[left];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseVal) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseVal) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        array[left] = array[rightIndex];
        array[rightIndex] = baseVal;
        return rightIndex;
    }

    //归并
    public void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        mergeSortHelper(array, 0, array.length);
    }

    private void mergeSortHelper(int[] array, int left, int right) {

        if (right - left <= 1) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSortHelper(array, left, mid);
        mergeSortHelper(array, mid, right);
        merge(array, left, mid, right);

    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int[] tmpArray = new int[right - left];
        int tmpIndex = 0;
        while (leftIndex < mid && rightIndex < right) {
            if (array[leftIndex] <= array[rightIndex]) {
                tmpArray[tmpIndex] = array[leftIndex];
                leftIndex++;
            } else {
                tmpArray[tmpIndex] = array[rightIndex];
                rightIndex++;
            }
            tmpIndex++;
        }
        while (leftIndex < mid) {
            tmpArray[tmpIndex] = array[leftIndex];
            leftIndex++;
            tmpIndex++;
        }
        while (rightIndex < right) {
            tmpArray[tmpIndex] = array[rightIndex];
            tmpIndex++;
            rightIndex++;
        }
        for (int i = 0; i < tmpArray.length; i++) {
            array[left + i] = tmpArray[i];
        }
    }

    //非递归快排
    public void quickSortDeep(int[] array) {

    }

}
