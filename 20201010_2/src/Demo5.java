import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 17:16
 */
public class Demo5 {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Thread thread = new Thread() {
            @Override
            public void run() {
                reentrantLock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        };

        thread.start();
        Thread.sleep(100);
        //注意使用这个方法必须在lock下使用, 不然会没有这个对象监视器的所有权而抛出异常
        reentrantLock.lock();
        System.out.println("有没有等待signal的线程 " + reentrantLock.hasWaiters(condition));
        reentrantLock.unlock();
    }
}
