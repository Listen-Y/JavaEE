/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 20:42
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        DealThread dealThread = new DealThread();
        dealThread.setUserName("a");
        Thread thread = new Thread(dealThread);
        thread.start();
        //注意这里是等待0.1秒 而线程是等待三秒
        Thread.sleep(100);

        dealThread.setUserName("b");
        Thread thread1 = new Thread(dealThread);
        thread1.start();
    }

}
