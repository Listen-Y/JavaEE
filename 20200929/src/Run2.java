/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 9:55
 */
public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        DaemonTest daemonTest = new DaemonTest();
        //将daemonTest设置为守护线程
        daemonTest.setDaemon(true);
        daemonTest.start();
        Thread.sleep(5000);
        System.out.println("非守护线程执行完毕, 守护线程应该停止");
    }
}
