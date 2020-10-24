/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 9:30
 */
public class Run {

    public static void main(String[] args) {
        System.out.println("我是main我的优先级是:" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(9);
        System.out.println("我是修改后的main我的优先级是:" + Thread.currentThread().getPriority());
        MyThread1 thread1 = new MyThread1();
        thread1.start();
    }
}
