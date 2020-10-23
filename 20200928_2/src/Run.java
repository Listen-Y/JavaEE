/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-28
 * Time: 21:55
 */
public class Run {

    public static void main(String[] args) {
        CurrentThreadTest threadTest = new CurrentThreadTest();
        System.out.println("main方法name:" + Thread.currentThread().getName());
        threadTest.start();
    }
}
