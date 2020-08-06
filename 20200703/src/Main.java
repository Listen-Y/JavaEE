import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();

            float m = 0;
            if (n != 1) {
                m = func(n);
                m = m * 100;
                System.out.printf("%.2f",m);
                System.out.println("%");
            } else {
                System.out.printf("%.2f",m);
                System.out.println("%");
            }
        }
    }

    private static float func(int n) {
        int m = n;
        float ret = 1;
        while (n != 1) {
            ret *= (float) (n - 1) / m;
            n--;
        }
        return ret;
    }
}
