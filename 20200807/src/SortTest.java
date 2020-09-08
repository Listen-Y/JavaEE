/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-08
 * Time: 7:54
 */
public class SortTest {
    //插入排序
    public void insertSort(int[] array) {
        for (int index = 1; index < array.length; index++) {
            int tmp = array[index];
            for (int prevIndex = index - 1; prevIndex >= 0; prevIndex--) {
                if (array[prevIndex] > tmp) {
                    array[prevIndex + 1] = array[prevIndex];
                } else {
                    array[prevIndex + 1] = tmp;
                    break;
                }
            }
        }
    }
    //选择排序
    public void selectSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
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
        int gap = array.length / 2;
        while (gap >= 1) {
            for (int index = gap; index < array.length; index++) {
                for (int prevIndex = index - gap; prevIndex >= 0; prevIndex -= gap) {
                    int tmp = array[index];
                    if (array[prevIndex] > tmp) {
                        array[prevIndex + gap] = array[prevIndex];
                    } else {
                        array[prevIndex + gap] = tmp;
                        break;
                    }
                }
            }
            gap /= 2;
        }
    }
    //冒泡排序
    public void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = 0; i < array.length - bound - 1; i++) {
                if (array[i + 1] < array[i]) {
                    int tmp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public void bubbleSort2(int[] array) {
        for (int bound = 0; bound < array.length; bound++) {
            for (int i = array.length - 1; i > bound; i--) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }
    //堆排序
    public void heapSort(int[] array) {
        heapSortHealer(array);

        for (int heapSize = array.length - 1; heapSize > 0; heapSize--) {
            int tmp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = tmp;
            shiftDown(array, heapSize, 0);
        }
    }

    private void heapSortHealer(int[] array) {
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private void shiftDown(int[] array, int size, int parent) {
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] < array[child]) {
                child++;
            } else {
                if (array[child] < array[parent]) {
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
    }
    //快速排序
    //归并排序
}
