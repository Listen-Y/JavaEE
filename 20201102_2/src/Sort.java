/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-02
 * Time: 21:54
 */
public class Sort {

    //插入排序
    public void insertSort(int[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        for (int bound = 1; bound < array.length; bound++) {
            int temp = array[bound];
            int prev;
            for(prev = bound - 1; prev >= 0; prev--) {
                if (array[prev] > array[prev + 1]) {
                    array[prev + 1] = array[prev];
                } else {
                    break;
                }
            }
            array[prev] = temp;
        }
    }

    //希尔排序
    public void shellSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int bound = gap; bound < array.length; bound++) {
                int temp = array[bound];
                int prev;
                for (prev = bound - gap; prev >= 0; prev -= gap) {
                    if (array[prev] > array[prev + gap]) {
                        array[prev + gap] = array[prev];
                    } else {
                        break;
                    }
                }
                array[prev] = temp;
            }
            gap = gap >> 1;
        }
    }

    //选择排序
    public void chanceSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int bound = 0; bound < array.length; bound++) {
            for (int next = bound + 1; next < array.length; next++) {
                if (array[next] < array[bound]) {
                    int tmp = array[next];
                    array[next] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }

    //冒泡排序
    public void bobbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        for (int bound = 0; bound < array.length; bound++) {
            for (int next = 0; next < array.length - 1 - bound; next++) {
                if (array[next] > array[next + 1]) {
                    int tmp = array[next];
                    array[next] = array[next + 1];
                    array[next + 1] = tmp;
                }
            }
        }
    }
    
    //堆排序
    public void heapSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        createHeap(array);
        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[heapSize];
            array[heapSize] = array[0];
            array[0] = tmp;
            shiftDown(0, array, heapSize);
        }
    }

    private void createHeap(int[] array) {
        for (int index = (array.length - 1 - 1) / 2; index >= 0; index--) {
            shiftDown(index, array, array.length);
        }
    }

    private void shiftDown(int index, int[] array, int size) {
        int parent = index;
        int children = 2 * parent + 1;
        while (children < size) {
            if (children + 1 < size && array[children + 1] > array[children]) {
                children++;
            }
            if (array[children] > array[parent]) {
                int tmp = array[children];
                array[children] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = children;
            children = 2* parent + 1;
        }
    }

    //快速排序
    public void quickSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        sort(array, left, index - 1);
        sort(array, index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int baseVal = array[left];
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] > baseVal) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] < baseVal) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        array[left] = array[leftIndex];
        array[leftIndex] = baseVal;
        return leftIndex;
    }

    //归并排序
    public void mergeSort(int[] array) {
        helper(array, 0, array.length);
    }

    private void helper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (left + right) >> 1;
        helper(array, left, mid);
        helper(array, mid, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int curIndex = 0;
        int[] curNums = new int[right - left];
        while (leftIndex < mid && rightIndex < right) {
            if (array[leftIndex] < array[rightIndex]) {
                curNums[curIndex] = array[leftIndex];
                leftIndex++;
            } else {
                curNums[curIndex] = array[rightIndex];
                rightIndex++;
            }
            curIndex++;
        }
        while (leftIndex < mid) {
            curNums[curIndex] = array[leftIndex];
            leftIndex++;
            curIndex++;
        }
        while (rightIndex < right) {
            curNums[curIndex] = array[rightIndex];
            curIndex++;
            rightIndex++;
        }
        for (int i = 0; i < right - left; i++) {
            array[left + i] = curNums[i];
        }
    }

}
