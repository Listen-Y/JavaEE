import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 17:17
 */
public class Demo2 {

    public static void main(String[] args) {
        //三表示他这一组有三个线程需要等待, 只有三个线程都在执行了await, 他们才会继续执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("AAA");
            }
        });
        RunnableDemo runnableDemo = new RunnableDemo(cyclicBarrier);
        //创建三个线程
        Thread a = new Thread(runnableDemo, "A");
        Thread b = new Thread(runnableDemo, "B");
        Thread c = new Thread(runnableDemo, "C");
        a.start();
        b.start();
        c.start();
    }
}

class RunnableDemo implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public RunnableDemo(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " 进入run方法");
        try {
            cyclicBarrier.await();
            System.out.println(Thread.currentThread().getName() + " 离开run方法");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
