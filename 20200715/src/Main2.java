import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(" ");
            StringBuilder builder = new StringBuilder();
            for (int i = strings.length - 1; i >= 0; i--) {
                builder.append(strings[i]).append(" ");
            }
            System.out.println(builder.toString().trim());
        }
    }
}
