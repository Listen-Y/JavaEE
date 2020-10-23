/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-28
 * Time: 22:13
 */
public class Run3 {

    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        System.out.println("main begin thread isAlive=" + thread.isAlive());
        thread.setName("AAA");
        thread.start();
        System.out.println("main end thread isAlive=" + thread.isAlive());
        System.out.println();
    }
}
