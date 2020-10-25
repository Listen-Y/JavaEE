import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 18:25
 */
public class Run {

    private static ReentrantLock reentrantLock = new ReentrantLock();
    //关键变量
    volatile private static int key = 1;
    //三个condition保证三种线程 挨个运行
    private static Condition conditionA = reentrantLock.newCondition();
    private static Condition conditionB = reentrantLock.newCondition();
    private static Condition conditionC = reentrantLock.newCondition();

    public static void main(String[] args) {
        //实现三个runnable任务
        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    while (key != 1) {
                        conditionA.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                    key = 2;
                    //唤醒所有B线程
                    conditionB.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        };
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    while (key != 2) {
                        conditionB.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                    key = 3;
                    //唤醒所有C线程
                    conditionC.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        };
        Runnable runnableC = new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                    while (key != 3) {
                        conditionC.await();
                    }
                    for (int i = 0; i < 3; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                    key = 1;
                    //唤醒所有A线程
                    conditionA.signalAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
        };

        //创建多个线程
        Thread[] threadsA = new Thread[5];
        Thread[] threadsB = new Thread[5];
        Thread[] threadsC = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threadsA[i] = new Thread(runnableA, "ThreadA");
            threadsB[i] = new Thread(runnableB, "ThreadB");
            threadsC[i] = new Thread(runnableC, "ThreadC");
        }
        //启动所有线程
        for (int i = 0; i < 5; i++) {
            threadsA[i].start();
            threadsB[i].start();
            threadsC[i].start();
        }
    }
}
