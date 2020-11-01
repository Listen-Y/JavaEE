import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 15:22
 */
public class Service4 {

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition conditionA = reentrantLock.newCondition();
    private Condition conditionB = reentrantLock.newCondition();

    public void awaitA() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        System.out.println(Thread.currentThread().getName() + " 执行awaitA");
        try {
            conditionA.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 运行结束");
            reentrantLock.unlock();
        }
    }

    public void awaitB() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        System.out.println(Thread.currentThread().getName() + " 执行awaitB");
        try {
            conditionB.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " 运行结束");
            reentrantLock.unlock();
        }
    }

    public void signalA() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        System.out.println(Thread.currentThread().getName() + " 执行signalA");

            conditionA.signal();
            System.out.println(Thread.currentThread().getName() + " 运行结束");
            reentrantLock.unlock();

    }

    public void signalAandB() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        System.out.println(Thread.currentThread().getName() + " 执行signalAandB");

        conditionA.signal();
        conditionB.signal();
        System.out.println(Thread.currentThread().getName() + " 运行结束");
        reentrantLock.unlock();
    }

    public void signalB_All() {
        reentrantLock.lock();
        System.out.println(Thread.currentThread().getName() + " 开始运行");
        System.out.println(Thread.currentThread().getName() + " 执行signalB_All");

        conditionB.signalAll();
        System.out.println(Thread.currentThread().getName() + " 运行结束");
        reentrantLock.unlock();
    }
}
