import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 16:46
 */
public class Demo1 {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread = new Thread() {
            @Override
            public void run() {
                method1();
            }

            public void method1() {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " " +
                        reentrantLock.getHoldCount());
                method2();
                reentrantLock.unlock();
            }

            public void method2() {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + " " +
                        reentrantLock.getHoldCount());
                reentrantLock.unlock();
            }
        };
        thread.start();
    }
}
