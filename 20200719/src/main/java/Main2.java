import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    private static int[] numbs;
    private static List<String> list;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            list = new ArrayList<>();
             numbs = new int[n];
            for (int i = 0; i < n; i++) {
                numbs[i] = i + 1;
            }
            func(0, "", m);
            Collections.sort(list);
            for (String s : list
                 ) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    builder.append(s.charAt(i)).append(" ");
                }
                System.out.println(builder.toString().trim());
            }
        }

    }

    private static void func(int index, String str, int m) {

        if (m == 0) {
            if (str.toString().length() != 0) {
                list.add(str);
            }
            return;
        }
        if (index >= numbs.length) {
            return;
        }
        func(index + 1, str + numbs[index], m - numbs[index]);
        func(index + 1, str, m);

    }

}
