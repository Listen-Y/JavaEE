import java.util.*;

public class Substr {
    public static boolean[] chkSubStr(String[] p, int n, String s) {
        // write code here
        boolean[] booleans = new boolean[n];
        for (int i = 0; i < n; i++) {
            booleans[i] = s.contains(p[i]);
        }
        return booleans;
    }

    public static void main(String[] args) {
        String[] p = {"a", "b", "c", "d"};
        System.out.println(Arrays.toString(chkSubStr(p, 4, "abc")));
    }
}