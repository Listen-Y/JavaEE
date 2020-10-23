/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-28
 * Time: 21:54
 */
public class CurrentThreadTest extends Thread{


    public CurrentThreadTest() {
        System.out.println("构造方法name:" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run方法name:" + Thread.currentThread().getName());
    }
}
