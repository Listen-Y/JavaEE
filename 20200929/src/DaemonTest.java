/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 9:51
 */
public class DaemonTest extends Thread {

    @Override
    public void run() {
        try {
            int i = 0;
            while (true) {
                System.out.println("i=" + i++);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
