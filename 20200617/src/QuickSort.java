import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[] {9,8,7,6,5,4,3,2,1,0};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums) {
        quickSortHelper(nums, 0, nums.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = pararation(array, left, right);

        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int pararation(int[] array, int left, int right) {

        int baseVal = array[left];
        int leftIndex = left;
        int rightIndex = right;

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
        array[left] = array[leftIndex];
        array[leftIndex] = baseVal;
        return leftIndex;
    }
}
