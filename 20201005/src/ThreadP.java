/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-05
 * Time: 14:12
 */
public class ThreadP extends Thread {

    private ServiceResources resources;

    public ThreadP(ServiceResources resources, String name) {
        this.resources = resources;
        this.setName(name);
    }

    @Override
    public void run() {
        while (true) {
            try {
                resources.push();
            } catch (InterruptedException e) {
                break;
            }
        }

    }
}
