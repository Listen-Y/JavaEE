import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String  str = scanner.nextLine();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a'
                        || str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                    int length = 0;
                    while (str.charAt(i) <= 'z' && str.charAt(i) >= 'a'
                            || str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                        length++;
                        i++;
                        if (i == str.length()) {
                            break;
                        }
                    }
                    String key = str.substring(i - length, i);
                    list.add(key);
                }
            }
            StringBuilder builder = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                builder.append(list.get(i)).append(" ");
            }
            System.out.println(builder.toString().trim());
        }

    }

}
