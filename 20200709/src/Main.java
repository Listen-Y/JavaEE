import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String trueStr = scanner.nextLine();
            String falseStr = scanner.nextLine();
            StringBuilder builder = new StringBuilder();

            trueStr = trueStr.toUpperCase();
            falseStr = falseStr.toUpperCase();

            for (int i = 0; i < trueStr.length(); i++) {
                char key = trueStr.charAt(i);
                if (! falseStr.contains(String.valueOf(key))
                        && !builder.toString().contains(String.valueOf(key))) {
                    builder.append(key);
                }
            }

            System.out.println(builder.toString());

        }
    }

}
