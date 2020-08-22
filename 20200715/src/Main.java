import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            if (func(s)) {
                System.out.println("YES");
            } else if (funcAddOne(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    private static boolean funcAddOne(String s) {

        if (s == null) {
            return false;
        }

        for (int i = 0; i < s.length() / 2; i++) {
            char c = s.charAt(s.length() - 1 - i);
            if (s.charAt(i) != c) {
                String builder = s.substring(0, i) + c + s.substring(i);

                String builder1 = s.substring(0, s.length() - i) + s.charAt(i);
                if (i != 0) {
                    builder1 = builder1 + s.substring(s.length() - i);
                }

                return func(builder) || func(builder1);
            }
        }
        return true;
    }

    private static boolean func(String s) {

        if (s == null) {
            return false;
        }
        StringBuilder builder = new StringBuilder(s);

        return builder.reverse().toString().equals(s);
    }

    public static void main1(String[] args) {
        int[][] arr = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        /*for (int[] nums : arr
             ) {
            System.out.println(Arrays.toString(nums));
        }*/
        System.out.println(Arrays.toString(arrayPrint(arr, 4)));
    }

    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] rets = new int[n * n];
        int index = 0;
        int wide = n - 1;
        int heap = 0;
        int count = n - 1;
        while (wide < n && heap < n && Math.abs(count) < n) {
            //System.out.println(arr[heap][wide]);
            rets[index++] = arr[heap++][wide++];

            if (wide >= n || heap >= n) {
                count--;
                if (count >= 0) {
                    heap = 0;
                    wide = count;
                } else {
                    wide = 0;
                    heap = Math.abs(count);
                }
            }
        }
        return rets;
    }
}
