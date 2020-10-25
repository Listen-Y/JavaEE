/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 18:00
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        Service1 service1 = new Service1();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行method时间" +
                        System.currentTimeMillis());
                service1.method();
            }
        };
        Thread a = new Thread(runnable, "A");
        a.start();
        Thread b = new Thread(runnable, "B");
        b.start();
    }
}
