import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
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
        int[] rets = new int[aTokens.length];
        for (int i = aTokens.length - 1; i >= 0; i--) {
            rets[i] = aTokens[i] - pTokens[i];
        }
        //从最后一项到倒数第二项 如果小于0就像前面借一位
        for (int i = 2; i > 0; i--) {
            while (rets[i] < 0) {
                rets[i - 1] -= 1;
                if (i == 2) {
                    rets[i] = 29 + rets[i];
                } else {
                    rets[i] = 17 + rets[i];
                }
            }
        }
        //拼装成string
        return rets[0] + "." + rets[1] + "." + rets[2];
    }
}
