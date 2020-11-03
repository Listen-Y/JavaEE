/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 13:43
 */
public class Demo3 {

    public static void main(String[] args) {
        //演示写写互斥
        Service service = new Service();
        Thread a = new Thread("A") {
            @Override
            public void run() {
                service.read();
            }
        };
        Thread b = new Thread("B") {
            @Override
            public void run() {
                service.write();
            }
        };
        a.start();
        b.start();
    }
}
