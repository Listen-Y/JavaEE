import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String goat = scanner.nextLine();
            String temp = scanner.nextLine();

            for (int i = 0; i < temp.length(); i++) {
                char kay = temp.charAt(i);
                goat = goat.replaceAll(String.valueOf(kay), "");
            }

            System.out.println(goat);
        }
    }
}
