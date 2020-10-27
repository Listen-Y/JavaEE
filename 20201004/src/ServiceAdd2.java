import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-04
 * Time: 21:54
 */
public class ServiceAdd2 {

    public AtomicInteger count = new AtomicInteger(0);

    public void addOne() {
        System.out.println("执行加一: " + count.addAndGet(1));
    }

    public void addHundred() {
        System.out.println("执行加一百: " + count.addAndGet(100));
    }

}
