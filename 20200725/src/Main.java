/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-25
 * Time: 9:15
 */
public class Main {

    public static void main(String[] args) {
        int[] A = new int[] {2, 7, 3, 1, 1};
        System.out.println(findMaxGap(A, 5));
    }

    public static int findMaxGap(int[] A, int n) {
        // write code here
        int index = n - 2;
        int result = 0;
        for (int i = 0; i <= index; i++) {
            int max = findMax(A, i);
            int min = findMin(A, i + 1);
            if (Math.abs(max - min) > result) {
                result = Math.abs(max - min);
            }
        }
        return result;
    }

    private static int findMin(int[] a, int index) {

        int max = a[index];
        for (int i = index + 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;

    }

    private static int findMax(int[] a, int index) {

        int max = a[0];
        for (int i = 1; i <= index; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        return max;

    }

}
