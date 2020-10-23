/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-28
 * Time: 22:00
 */
public class IsAliveTest extends Thread {

    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
