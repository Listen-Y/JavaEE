import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-09
 * Time: 23:12
 */
public class Demo {

    public static ThreadLocal<Date> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        //创建俩个线程去挨个保存当前时间
        Thread a = new Thread("A") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    threadLocal.set(new Date());
                    System.out.println(Thread.currentThread().getName() + " " + threadLocal.get().getTime());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread b = new Thread("B") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    threadLocal.set(new Date());
                    System.out.println(Thread.currentThread().getName() + " " + threadLocal.get().getTime());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        a.start();
        b.start();
        a.join();
        b.join();

    }
}
