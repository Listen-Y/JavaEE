import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 16:52
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        };
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }
        Thread.sleep(100);
        System.out.println(reentrantLock.getQueueLength());
    }
}
