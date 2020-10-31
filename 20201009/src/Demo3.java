import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-09
 * Time: 23:44
 */
public class Demo3 {

    public static InheritableThreadLocal inheritableThreadLocal = new InheritableThreadLocal() {
        @Override
        protected Object initialValue() {
            return new Date().getTime();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main get " + inheritableThreadLocal.get());
        System.out.println("main set...");
        Thread.sleep(222);
        inheritableThreadLocal.set(new Date().getTime());
        System.out.println("main get " + inheritableThreadLocal.get());

        Thread thread = new Thread("A") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("A get " + inheritableThreadLocal.get());
                    try {
                        Thread.sleep(222);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        Thread.sleep(1000);
        System.out.println("main 再次set...");
        inheritableThreadLocal.set(new Date().getTime());
        System.out.println("main get " + inheritableThreadLocal.get());
        thread.join();

    }
}
