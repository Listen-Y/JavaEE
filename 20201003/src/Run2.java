/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 21:21
 */
public class Run2 {


    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Thread t1 = new Thread("A") {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        Thread t2 = new Thread("B") {
            @Override
            public void run() {
                service.testMethod();
            }
        };
        t1.start();
        //关键点 这里等待0.1秒, A线程等待2秒
        //Thread.sleep(100);
        t2.start();
    }
}
