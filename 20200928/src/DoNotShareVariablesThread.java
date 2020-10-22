/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-27
 * Time: 22:45
 */
public class DoNotShareVariablesThread extends Thread {

    private int i = 5;

    public DoNotShareVariablesThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {

        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + "计算出i=" + i);
        }
    }
}
