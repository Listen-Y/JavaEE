/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 9:21
 */
public class PrioritySet {

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(this.getPriority());
                this.setPriority(3);
                System.out.println(this.getPriority());
            }
        };
        thread.start();

    }
}
