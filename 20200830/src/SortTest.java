import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-30
 * Time: 15:16
 */
public class SortTest {

    //插入排序
    public void insertSort(int[] array) {
        if (array == null ||array.length == 0) {
            return;
        }
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int i;
            for (i = bound - 1; i >= 0; i--) {
                if (array[i] > tmp) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = tmp;
        }
    }
    //选择排序
    public void chanceSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int bound = 0; bound < array.length - 1; bound++) {
            for (int i = bound + 1; i < array.length; i++) {
                if (array[i] < array[bound]) {
                    int tmp = array[i];
                    array[i] = array[bound];
                    array[bound] = tmp;
                }
            }
        }
    }
    //希尔排序
    public void shellSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int bound = gap; bound < array.length; bound++) {
                int tmp = array[bound];
                int i = 0;
                for (i = bound - gap; i >= 0; i -= gap) {
                    if (array[i] > tmp) {
                        array[i + gap] = array[i];
                    } else {
                        break;
                    }
                }
                array[i + gap] = tmp;
            }
            gap /= 2;
        }
    }
    //冒泡排序
    public void bubbleSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
    //堆排序
    public void headSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //升序排序 建大堆
        createHeap(array);
        //数组长度减一然后将第一个数与最后一个数互换最后来一个向下调整
        for (int heapSize = array.length - 1; heapSize >= 0; heapSize--) {
            int tmp = array[heapSize];
            array[heapSize] = array[0];
            array[0] = tmp;
            shiftDown(array, 0, heapSize);
        }
    }

    private void createHeap(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, i, array.length);
        }
    }

    private void shiftDown(int[] array, int parent, int size) {
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child++;
            }
            if (array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
        }
    }
    //快速排序
    public void quickSort(int[] array) {
        if (array == null ||array.length == 0) {
            return;
        }
        quickSortHelper(array, 0, array.length - 1);
    }

    private void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = partition(array, left, right);
        quickSortHelper(array, left, index);
        quickSortHelper(array, index + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int baseValue = array[left];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex < rightIndex) {
            while (leftIndex < rightIndex && array[rightIndex] >= baseValue) {
                rightIndex--;
            }
            while (leftIndex < rightIndex && array[leftIndex] <= baseValue) {
                leftIndex++;
            }
            if (leftIndex < rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
        }
        array[left] = array[leftIndex];
        array[leftIndex] = baseValue;
        return leftIndex;
    }
    //归并排序
    public void mergeSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        mergeSortHelper(array, 0, array.length);
    }

    private void mergeSortHelper(int[] array, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int index = (left + right) / 2;
        mergeSortHelper(array, left, index);
        mergeSortHelper(array, index, right);
        merge(array, left, index, right);
    }

    private void merge(int[] array, int left, int index, int right) {
        int leftIndex = left;
        int rightIndex = right;
        int midIndex = index;
        int tmpIndex = 0;
        int[] tmpArray = new int[right - left];
        while (leftIndex < index && midIndex < right) {
            if (array[leftIndex] <= array[midIndex]) {
                tmpArray[tmpIndex] = array[leftIndex];
                leftIndex++;
            } else {
                tmpArray[tmpIndex] = array[midIndex];
                midIndex++;
            }
            tmpIndex++;
        }
        while (leftIndex < index) {
            tmpArray[tmpIndex] = array[leftIndex];
            leftIndex++;
            tmpIndex++;
        }
        while (midIndex < right) {
            tmpArray[tmpIndex] = array[midIndex];
            midIndex++;
            tmpIndex++;
        }
        for (int i = 0; i < tmpArray.length; i++) {
            array[left + i] = tmpArray[i];
        }

    }
    //快排非递归
    public void quickSortByLoop(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        //主要操作还是partition 非递归只是把下标处理清除就好
        Queue<Integer> indexes = new LinkedList<>();
        indexes.offer(0);
        indexes.offer(array.length - 1);
        while (!indexes.isEmpty()) {
            int left = indexes.poll();
            int right = 0;
            if (!indexes.isEmpty()) {
                 right = indexes.poll();
            }
            if (left < right) {
                int index = partition(array, left, right);
                indexes.offer(left);
                indexes.offer(index - 1);
                indexes.offer(index + 1);
                indexes.offer(right);
            }


        }
    }
    //归并非递归
    public void mergeSortByLoop(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int gap = 1; gap < array.length; gap *= 2) {
            for (int left = 0; left < array.length; left += 2 * gap) {
                int mid = left + gap;
                int right = mid + gap;
                if (mid > array.length) {
                    mid = array.length;
                }
                if (right > array.length) {
                    right = array.length;
                }
                merge(array, left, mid, right);
            }
        }
    }

}
