import java.util.*;

public class Main4 {
    public static int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        for (int i = n; i <= n; i++) {
            String str = String.valueOf(i);
            while (str.contains("2")) {
                str = str.replace('2', '0');
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            System.out.println(countNumberOf2so(n));
        }
    }



    public static int countNumberOf2so(int n) {
            // write code here
            int res = 0;
            for(int i=1;i<=n;i*=10){
                int a = n/i;
                int b = n%i;
                res += (a+7)/10*i + ((a%10==2)?(b+1):0);
            }
            return res;
        }

}