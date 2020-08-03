import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int num1 = num * num;
            String numStr = String.valueOf(num);
            String num1Str = String.valueOf(num1);
            int sum = 0;
            for (int i = 0; i < numStr.length(); i++) {
                char c = numStr.charAt(i);
                sum += Integer.parseInt(c + "");
            }
            int sum1 = 0;
            for (int i = 0; i < num1Str.length(); i++) {
                char c = num1Str.charAt(i);
                sum1 += Integer.parseInt(c + "");
            }

            System.out.println(sum + " " + sum1);
        }
    }
}
