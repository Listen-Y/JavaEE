/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 21:54
 */
public class ThreadA extends Thread {

    private final Thread b;

    public ThreadA(Thread b, String name) {
        this.b = b;
        this.setName(name);
    }

    @Override
    public void run() {
        synchronized (b) {
            System.out.println(this.getName() + " 开始: " + System.currentTimeMillis());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " 结束: " + System.currentTimeMillis());
        }
    }
}
