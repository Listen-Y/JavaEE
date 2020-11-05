/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 17:55
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        //创建俩个runnable
        Runnable runnableA = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " " +
                            Thread.currentThread().getThreadGroup().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        Runnable runnableB = new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println(Thread.currentThread().getName() + " " +
                            Thread.currentThread().getThreadGroup().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
        //创建一个ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("Listen的Group");
        //创建俩个线程去执行runnable
        Thread a = new Thread(threadGroup, runnableA, "A");
        Thread b = new Thread(threadGroup, runnableB, "B");
        System.out.println(Thread.currentThread().getName() + " " +
                Thread.currentThread().getThreadGroup().getName());
        a.start();
        b.start();
        Thread.sleep(5000);
    }
}
