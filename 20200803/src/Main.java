/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-03
 * Time: 10:23
 */
import java.util.*;
public class Main {
    public static void main (String[] aerg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {

            String line = scan.nextLine();
            System.out.println(findStr(line));

        }
    }

    public static String findStr(String line) {

        if (line == null) {
            return null;
        }

        String ret = "";
        for (int i = 0; i < line.length(); i++) {
            StringBuffer buffer = new StringBuffer();
            while (i < line.length() && (line.charAt(i) >= '0' && line.charAt(i) <= '9')) {
                buffer.append(line.charAt(i));
                i++;
            }
            if (buffer.toString().length() > ret.length()) {
                ret = buffer.toString();
            }
        }
        return ret;
    }
}