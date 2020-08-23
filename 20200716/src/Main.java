import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = scanner.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            int bigSum = 0;
            int index = 0;
            int sum = nums[0];

            while (index < n - 1) {

                if (nums[index + 1] > nums[index]) {
                    sum += nums[index + 1];
                } else {
                    if (sum > bigSum) {
                        bigSum = sum;
                    }
                    sum = nums[index + 1];
                }
                index++;
            }
            if (sum > bigSum) {
                bigSum = sum;
            }

            index = 0;
            sum = nums[0];
            while (index < n - 1) {

                if (nums[index + 1] < nums[index]) {
                    sum += nums[index + 1];
                } else {
                    if (sum > bigSum) {
                        bigSum = sum;
                    }
                    sum = nums[index + 1];
                }
                index++;
            }
            if (sum > bigSum) {
                bigSum = sum;
            }

            System.out.println(bigSum);
        }
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = scanner.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }

            for (int i = 0; i < n; i++) {
                func(i, nums);

            }
        }
    }

    private static void func(int index, int[] nums) {
        int left = index - 1;
        int right = index + 1;

        while (left >= 0) {
            if (nums[left] < nums[index]) {
                break;
            }
            left--;
        }

        while (right < nums.length) {
            if (nums[right] < nums[index]) {
                break;
            }
            right++;
        }
        if (right == nums.length) {
            right = -1;
        }

        System.out.println(left + " " + right);
    }

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = scanner.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(strings[i]);
            }
            int[] keys = new int[2];
            int index = 0;

            Map<Integer, Integer> map = new HashMap<>();

            for (int x : nums
                 ) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()
                 ) {
                if (entry.getValue() % 2 != 0 && index < 2) {
                    keys[index++] = entry.getKey();
                }
            }

            Arrays.sort(keys);
            System.out.println(keys[0] + " " + keys[1]);
        }
    }
}
