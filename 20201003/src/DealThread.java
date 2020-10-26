/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 20:37
 */
public class DealThread implements Runnable {

    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //俩把锁
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();


    @Override
    public void run() {

        if ("a".equals(userName)) {
            synchronized (lock1) {
                System.out.println("userName=" + userName + " :" + "进入lock1");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock2) {
                    System.out.println("由lock1->进入->lock2");
                }
            }
        }

        if ("b".equals(userName)) {
            synchronized (lock2) {
                System.out.println("userName=" + userName + " :" + "进入lock2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lock1) {
                    System.out.println("由lock2->进入->lock1");
                }
            }
        }

    }
}
