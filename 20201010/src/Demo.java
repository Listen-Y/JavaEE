/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 14:40
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        //创建俩个线程
        Thread a = new Thread("A") {
            @Override
            public void run() {
                service.methodA();
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                service.methodA();
            }
        };
        a.start();
        b.start();
        a.join();
        b.join();
    }
}
