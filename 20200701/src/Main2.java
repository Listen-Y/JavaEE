import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         while (scanner.hasNext()) {
             int n = scanner.nextInt();
             String nStr = String.valueOf(n);
             int nn = n * n;
             String nnStr = String.valueOf(nn);

             if (nStr.equals(nnStr.substring(nnStr.length() - nStr.length()))) {
                 System.out.println("Yes!");
             } else {
                 System.out.println("No!");
             }
         }
    }
}
