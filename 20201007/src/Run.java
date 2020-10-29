/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-08
 * Time: 21:58
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {
        ThreadB threadB = new ThreadB("B");
        ThreadA threadA = new ThreadA(threadB, "A");
        threadA.start();
        threadB.start();
        threadB.join(2000);
        System.out.println(Thread.currentThread().getName() + " 结束" +
                System.currentTimeMillis());
    }
}
