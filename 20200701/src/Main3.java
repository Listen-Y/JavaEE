import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(isPassword(str));
        }
    }

    private static String isPassword(String str) {
        if (str == null ||str.length() <= 8) {
            return "NG";
        }
        if (haveKinds(str) < 3) {
            return "NG";
        }
        if (sameSre(str)) {
            return "NG";
        }

        return "OK";
    }

    private static boolean sameSre(String str) {
        for (int i = 0; i < str.length() - 3; i++) {
            String s1 = str.substring(i, i + 3);
            String s2 = str.substring(i + 1);
            if (s2.contains(s1)) {
                return true;
            }
        }
        return false;
    }

    private static int haveKinds(String str) {
        int isNum = 0;
        int isChar = 0;
        int isUpChar = 0;
        int others = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 97 && c <= 122) {
                isChar = 1;
            } else if (c >= 65 && c <= 90) {
                isUpChar = 1;
            } else if (c >= 48 && c <= 57) {
                isNum = 1;
            } else {
                others = 1;
            }
        }
        return isChar + isNum + isUpChar + others;
    }
}
