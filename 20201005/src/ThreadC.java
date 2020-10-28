/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-05
 * Time: 14:14
 */
public class ThreadC extends Thread {

    private ServiceResources resources;

    public ThreadC(ServiceResources resources, String name) {
        this.resources = resources;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                resources.take();
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
