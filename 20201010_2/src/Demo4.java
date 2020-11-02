import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 17:09
 */
public class Demo4 {

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
        Thread a = new Thread(runnable);
        a.start();
        Thread.sleep(100);
        Thread b = new Thread(runnable);
        b.start();
        Thread.sleep(100);
        System.out.println("a需要吗? " + reentrantLock.hasQueuedThread(a));
        System.out.println("b需要吗? " + reentrantLock.hasQueuedThread(b));
        System.out.println("有需要吗? " + reentrantLock.hasQueuedThreads());
    }
}
