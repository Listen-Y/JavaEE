import java.util.Arrays;
import java.util.Scanner;

class Main1 {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {

            String  s = scanner.nextLine();
            String[] ss = s.split(" ");
            StringBuilder builder1 = new StringBuilder();
            for (int i = 0; i < ss.length; i++) {
                int count =Integer.parseInt(ss[i]);
                while (count > 0) {
                    builder1.append(i);
                    count--;
                }
            }

            int[] nums = new int[builder1.length()];

            for (int i = 0; i < nums.length; i++) {

                nums[i] = builder1.charAt(i) - '0';
            }

            Arrays.sort(nums);

            if (nums[0] == 0) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i] != 0) {
                        int tmp = nums[0];
                        nums[0] = nums[i];
                        nums[i] = tmp;
                        break;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            for (int x : nums
                 ) {
                builder.append(x);
            }
            System.out.println(builder.toString());
        }
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int m = scanner.nextInt();

            int key = (m * (m + 1)) / 2;
            int lastNum = 2 * key - 1;

            for (int i = 0; i < m; i++) {
                lastNum -= 2;
            }

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < m; i++) {

                lastNum += 2;
                builder.append(lastNum);
                builder.append("+");

            }

            System.out.println(builder.subSequence(0, builder.length() - 1).toString());
        }
    }
}
