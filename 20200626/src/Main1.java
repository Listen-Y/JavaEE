import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String[] s = scanner.nextLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[] grads = new int[n + 1];
            String[] ss = scanner.nextLine().split(" ");
            for (int i = 1; i < n + 1; i++) {
                grads[i] = Integer.parseInt(ss[i - 1]);
            }

            for (int i = 0; i < m; i++) {
                String[] makes = scanner.nextLine().split(" ");
                if ("Q".equals(makes[0])) {
                    int A = Integer.parseInt(makes[1]);
                    int B = Integer.parseInt(makes[2]);
                    System.out.println(func(grads, A, B));
                } else {
                    int A = Integer.parseInt(makes[1]);
                    int B = Integer.parseInt(makes[2]);
                    grads[A] = B;
                }
            }
        }
    }

    private static int func(int[] grads, int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int ret = 0;
        for (int i = a; i <= b; i++) {
            if (grads[i] > ret) {
                ret = grads[i];
            }
        }

        return ret;
    }
}
