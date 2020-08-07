import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            BigInteger[] bigIntegers = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                bigIntegers[i] = new BigInteger(scanner.nextLine());
            }
            Arrays.sort(bigIntegers);
            for (int i = 0; i < n; i++) {
                System.out.println(bigIntegers[i]);
            }
        }
    }
}
