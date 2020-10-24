/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 11:30
 */
public class Run4 {

    public static void main(String[] args) {
        Service service = new Service();
        //创建俩个线程去执行
        ThreadA threadA = new ThreadA(service);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(service);
        threadB.setName("B");
        threadA.start();
        threadB.start();

    }
}
