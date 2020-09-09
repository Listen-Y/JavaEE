import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-10
 * Time: 9:59
 */
public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString().split(" ")[3].replaceAll(":", "_"));
    }
}
