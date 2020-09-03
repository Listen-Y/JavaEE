/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-29
 * Time: 9:54
 */
public class BinarySearch {

    public static boolean binarySearch(int[] arr, int val) {

        if (arr.length == 0) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > val) {
                right = mid - 1;
            } else if (arr[mid] < val) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(arr, 1));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(arr, 2));
        System.out.println(binarySearch(arr, 8));
        System.out.println(binarySearch(arr, 10));
    }

    public int minNumberInRotateArray(int [] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                int result = array[left];
                for (int i = left + 1; i < right; i++) {
                    if (array[i] < result) {
                        result = array[i];
                    }
                }
                return result;
            }
            if (array[left] <= array[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return array[mid];

    }

}
