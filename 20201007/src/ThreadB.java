/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 21:56
 */
public class ThreadB extends Thread {

    public ThreadB(String name) {
        this.setName(name);
    }

    @Override
    synchronized public void run() {
        System.out.println(this.getName() + " 开始: " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " 结束: " + System.currentTimeMillis());
    }
}
