import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int x0 = scanner.nextInt();
            int y0 = scanner.nextInt();
            int z0 = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int z1 = scanner.nextInt();

            double a = Math.pow(x0 - x1, 2);
            double b = Math.pow(y0 - y1, 2);
            double c = Math.pow(z0 - z1, 2);

            double r = Math.sqrt(a + b + c);

            double v = (4 * Math.PI * Math.pow(r, 3)) / 3;

            System.out.println(String.format("%.3f", r) + " " + String.format("%.3f", v));
        }
    }
}
