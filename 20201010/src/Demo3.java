/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-10
 * Time: 15:11
 */
public class Demo3 {

    public static void main(String[] args) throws InterruptedException {
        Service3 service3 = new Service3();
        Thread a = new Thread("A") {
            @Override
            public void run() {
                service3.methodAwait();
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                service3.methodSignal();
            }
        };
        a.start();
        Thread.sleep(100);
        b.start();
    }
}
