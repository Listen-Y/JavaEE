import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = scanner.nextLine();
            }

            Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    if (o1.length() != o2.length()) {
                        //如果长度不同则按长的为大数字
                        return o1.length() - o2.length();
                    } else {
                        //此时说明长度相同
                        //挨个比较数字的大小
                        for (int i = 0; i < o1.length(); i++) {
                            if (o1.charAt(i) != o2.charAt(i)) {
                                return o1.charAt(i) - o2.charAt(i);
                            }
                        }
                    }
                    //此时说明俩个数相等
                    return 0;
                }
            });

            for (String s : strings
                 ) {
                System.out.println(s);
            }
        }
    }
}
