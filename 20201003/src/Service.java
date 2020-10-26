/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-03
 * Time: 21:48
 */
public class Service {

    public void testMethod(User user) {
        synchronized (user) {
            System.out.println(Thread.currentThread().getName() + " begin: " +
                    System.currentTimeMillis());
            //修改信息
            user.age = 99;
            user.name = "HaHa";
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " end: " +
                    System.currentTimeMillis());
        }
    }

}
