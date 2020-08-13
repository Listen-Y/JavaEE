import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int[] counts = new int[26];

            for (int i = 0; i < s.length(); i++) {
                char key = s.charAt(i);
                int index = key - 'A';
                if (index >= 0 && index < 26) {
                    counts[index]++;
                }
            }

            for (int i = 0; i < 26; i++) {
                System.out.println((char) ('A' + i) + ":" + counts[i]);
            }
        }
    }
}
