import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            boolean key = true;
            for (int i = 0; i < n; i++) {
                if (nums[i] == x) {
                    System.out.println(i);
                    key = false;
                }
            }
            if (key) {
                System.out.println(-1);
            }
        }
    }
}
