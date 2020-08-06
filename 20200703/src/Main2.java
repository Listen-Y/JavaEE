import java.util.Scanner;

public class Main2 {

    private static int[] nums;
    private static int count;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            count = 0;
            func(sum, 0);
            System.out.println(count);
        }
    }

    private static void func(int sum, int index) {
        if (sum < 0) {
            return;
        }
        if (sum == 0) {
            count++;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        func(sum - nums[index], index + 1);
        func(sum, index + 1);
    }
}
