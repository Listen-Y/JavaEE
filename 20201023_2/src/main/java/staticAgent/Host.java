package staticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:00
 */
public class Host implements Lease {
    @Override
    public void lease() {
        System.out.println("房东Listen, 要出租房子");
    }

    @Override
    public int getRent() {
        return 10000;
    }
}
