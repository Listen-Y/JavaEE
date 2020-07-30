import java.math.BigDecimal;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String[] sreNums = scanner.nextLine().split(" ");
            int A1 = 0;
            int A2 = 0;
            boolean A2bool = true;
            int A3 = 0;
            int A4 = 0;
            int A4Count = 0;
            int A5 = 0;

            for (int i = 1; i < sreNums.length; i++) {
                int num = Integer.parseInt(sreNums[i]);
                int yuShu = num % 5;

                if (yuShu == 0) {
                    if (num % 2 == 0) {
                        A1 += num;
                    }
                } else if (yuShu == 1) {
                    if (A2bool) {
                        A2 += num;
                        A2bool = false;
                    } else {
                        A2 -= num;
                        A2bool = true;
                    }
                } else if (yuShu == 2) {
                    A3++;
                } else if (yuShu == 3) {
                    A4 += num;
                    A4Count++;
                } else if (yuShu == 4) {
                    if (num > A5) {
                        A5 = num;
                    }
                }
            }
            BigDecimal decimal = null;

            if (A4Count != 0) {
                decimal = new BigDecimal((A4 * 1.0) / A4Count);
                decimal = decimal.setScale(1, BigDecimal.ROUND_HALF_UP);
            }

            System.out.println((A1 == 0 ? "N" : A1) + " " + (A2 == 0 ? "N" : A2) + " " + (A3 == 0 ? "N" : A3)
                    + " " + (decimal == null || decimal.toString().equals("0") ? "N" : decimal.toString()) + " " + (A5 == 0 ? "N" : A5));
        }
    }
}
