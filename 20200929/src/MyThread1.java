/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-29
 * Time: 9:29
 */
public class MyThread1 extends Thread {

    @Override
    public void run() {
        this.setPriority(6);
        System.out.println("我是MyThread1我的优先级是:" + this.getPriority());
        MyThread2 thread2 = new MyThread2();
        thread2.start();
        int i = 0;
        while (true) {
            i++;
            System.out.println("我是MyThread1=" + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        this.setPriority(5);
        System.out.println("我是MyThread1我的优先级是:" + this.getPriority());
        int i = 0;
        while (true) {
            i++;
            System.out.println("我是MyThread2=" + i);
        }
    }
}
