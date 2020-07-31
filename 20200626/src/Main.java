import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            for (int x : b
                 ) {
                if (x <= a) {
                    a += x;
                } else {
                    a+= func(x, a);
                }
            }
            System.out.println(a);
        }
    }

    private static int func(int x, int a) {

        int num = a;
        while (x % num != 0 || a % num != 0) {
            num--;
        }
        return num;
    }
}
