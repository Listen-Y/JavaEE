import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            int index = 0;
            while ((index = str.indexOf('_')) != -1) {
                String old = str.substring(index, index + 2);
                String place = old.substring(1).toUpperCase();
                str = str.replaceAll(old, place);
            }
            System.out.println(str);
        }

    }

}
