import java.util.Arrays;
import java.math.*;

public class MergeSotrTest {

    public static void main(String[] args) {
        MergeSotrTest test = new MergeSotrTest();

        //math的abs是返回一个绝对值
        System.out.println(Math.abs(-12.3));

       /* int[] nums = new int[] {9,8,7,6,5,4,3,2,1};
        test.mergrSort(nums);

        System.out.println(Arrays.toString(nums));*/
    }

    public void mergrSort(int[] array) {
        mergrSortHelper(array, 0, array.length);
    }

    private void mergrSortHelper(int[] array, int left, int right) {

        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;
        mergrSortHelper(array, left, mid);
        mergrSortHelper(array, mid, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftIndex = left;
        int rightIndex = mid;
        int tmpIndex = 0;
        int[] tmpNums = new int[right - left];

        while (leftIndex < mid && rightIndex < right) {
            //为保证稳定性 所以这里得加等号
            if (array[leftIndex] <= array[rightIndex]) {
                tmpNums[tmpIndex] = array[leftIndex];
                leftIndex++;
            } else {
                tmpNums[tmpIndex] = array[rightIndex];
                rightIndex++;
            }
            tmpIndex++;
        }

        while (leftIndex < mid) {
            tmpNums[tmpIndex] = array[leftIndex];
            tmpIndex++;
            leftIndex++;
        }

        while (rightIndex < right) {
            tmpNums[tmpIndex] = array[rightIndex];
            rightIndex++;
            tmpIndex++;
        }

        for (int i = 0; i < right - left; i++) {
            array[left + i] = tmpNums[i];
        }
    }
}


