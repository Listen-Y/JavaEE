/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-24
 * Time: 10:30
 */
public class Test {

    public static void main(String[] args) {
        String ret = "a";
        ret += 'b';
        System.out.println(ret);
        ret = ret.substring(0, ret.length() - 1);
        System.out.println(ret);
    }
}
