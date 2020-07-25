import java.util.Scanner;

public class Main {

    private static int key = 0;
    private static String maxGC = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {

            String s = scanner.nextLine();
            int num = scanner.nextInt();
            key = 0;
            maxGC = "";
            find(s, 0, num);
            System.out.println(maxGC);
        }
    }

    private static void find(String s, int index, int num) {
        if (index + num > s.length()) {
            return;
        }
        String s1 = s.substring(index, index + num);
        int count = countGC(s1);
        if (count  > key) {
            maxGC = s1;
            key = count;
        }
        find(s, index + 1, num);
    }

    private static int countGC(String s1) {

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'G' || s1.charAt(i) == 'C') {
                count++;
            }
        }
        return count;
    }
}
