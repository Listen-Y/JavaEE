/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-28
 * Time: 22:04
 */
public class Run2 {

    public static void main(String[] args) throws InterruptedException {
        IsAliveTest test = new IsAliveTest();
        System.out.println("begin=" + test.isAlive());
        test.start();
        Thread.sleep(100);
        System.out.println("end=" + test.isAlive());
    }
}
