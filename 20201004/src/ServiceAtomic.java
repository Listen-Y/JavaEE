import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-04
 * Time: 21:47
 */
public class ServiceAtomic {

    public AtomicInteger count = new AtomicInteger(0);

    public void add() {
        count.incrementAndGet();
    }

}
