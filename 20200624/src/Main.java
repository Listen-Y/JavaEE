import java.util.Scanner;

class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int mouth = scanner.nextInt();
            System.out.println(gettotle(mouth));
        }
    }

    private static int gettotle(int mouth) {

        int a = 1;
        int b = 1;
        int c = 1;
        for (int i = 2; i < mouth; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String fake = scanner.nextLine();
            fun(fake);
            System.out.println();
        }
    }

    private static void fun(String fake) {

        for (int i = 0; i < fake.length(); i++) {
            char ch = fake.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                if ((ch + 5) <= 'Z') {
                    ch += 5;
                    System.out.print(ch);
                } else {
                    ch += 5;
                    ch -= 'A';
                    System.out.print(ch);
                }
            } else {
                System.out.print(ch);
            }
        }

    }
}
