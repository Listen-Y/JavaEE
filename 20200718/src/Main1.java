
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String encryption = scanner.nextLine();
            String deciphering = scanner.nextLine();

            funcEncryption(encryption);
            funcDeciphering(deciphering);

        }

    }

    private static void funcDeciphering(String deciphering) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < deciphering.length(); i++) {

            char c = deciphering.charAt(i);
            if (c >= '0' && c <= '9') {
                if (c == '0') {
                    c = '9';
                } else {
                    c -= 1;
                }
            } else {
                if (c == 'A') {
                    c = 'Z';
                } else {
                    c -= 1;
                }
                c += 32;
            }
            builder.append(c);
        }
        System.out.println(builder.toString());
    }

    private static void funcEncryption(String encryption) {

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < encryption.length(); i++) {

            char c = encryption.charAt(i);
            if (c >= '0' && c <= '9') {
                if (c == '9') {
                    c = '0';
                } else {
                    c += 1;
                }
            } else {
                if (c == 'z') {
                    c= 'a';
                } else {
                    c += 1;
                }
                c -= 32;
            }
            builder.append(c);

        }
        System.out.println(builder.toString());

    }

}
