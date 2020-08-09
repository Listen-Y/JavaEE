import java.util.Scanner;

public class BaseConversion {
    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            int n = scanner.nextInt();

            String tenToTwo = Integer.toBinaryString(n);
            System.out.println("10进制转2进制:" + tenToTwo);

            String tenToEight = Integer.toOctalString(n);
            System.out.println("10进制转8进制:" + tenToEight);

            String tenToSixteen = Integer.toHexString(n);
            System.out.println("10进制转16进制:" + tenToSixteen);

            String tenToAny = Integer.toString(n, 5);
            System.out.println("10进制转 Any 进制:" + tenToAny);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String s = scanner.nextLine();

            int num = Integer.parseInt(s, 2);
            System.out.println("二进制转10进制:" + num);

            String s1 = scanner.nextLine();
            int num1 = Integer.parseInt(s1, 8);
            System.out.println("8进制转10进制" + num1);
        }
    }


}
