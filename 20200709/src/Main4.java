import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int index = s.indexOf("x");
            s = s.substring(index + 1);
            System.out.println(Integer.valueOf(s, 16));
        }
    }
}
