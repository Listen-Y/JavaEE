import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] pa = scanner.nextLine().split(" ");
            String p = pa[0];
            String a = pa[1];
            //p是应付  a是实付
            String[] ps = p.split("\\.");
            String[] as = a.split("\\.");
            int[] pTokens = new int[ps.length];
            for (int i = 0; i < pTokens.length; i++) {
                pTokens[i] = Integer.parseInt(ps[i]);
            }
            int[] aTokens = new int[as.length];
            for (int i = 0; i < aTokens.length; i++) {
                aTokens[i] = Integer.parseInt(as[i]);
            }

            System.out.println(func(pTokens, aTokens));
        }
    }

    //p是应付  a是实付
    private static String func(int[] pTokens, int[] aTokens) {
        /*System.out.println(Arrays.toString(aTokens));
        System.out.println(Arrays.toString(pTokens));*/
        String ret = null;
        //计算最后一项
        while (aTokens[2] < pTokens[2]) {
            aTokens[2] += 29;
            aTokens[1] -= 1;
            if (aTokens[2] > 29) {
                aTokens[2] = 29;
            }
        }
        ret = String.valueOf(aTokens[2] - pTokens[2]);
        //计算第二项
        while (aTokens[1] < pTokens[1]) {
            aTokens[1] += 17;
            aTokens[0] -= 1;
            if (aTokens[1] > 18) {
                aTokens[1] = 18;
            }
        }
        ret = String.valueOf(aTokens[1] - pTokens[1]) + "." + ret;
        //计算第一项
        ret = String.valueOf(aTokens[0] - pTokens[0]) + "." + ret;
        return ret;
    }
}
