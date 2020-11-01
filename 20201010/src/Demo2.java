/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 14:50
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        //传入true表示公平, 传入false表示不公平
        Service2 service2 = new Service2(false);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                service2.method();
            }
        };
        //创建多个线程
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
    }
}
