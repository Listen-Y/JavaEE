import java.util.concurrent.Exchanger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 18:17
 */
public class Demo4 {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA threadA = new ThreadA(exchanger);
        ThreadB threadB = new ThreadB(exchanger);
        threadA.start();
        threadB.start();
    }
}

class ThreadA extends Thread {

    private Exchanger<String> exchanger;

    public ThreadA(Exchanger<String> exchanger) {
        this.setName("A");
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String a = "我是Java代码";
        try {
            String b = exchanger.exchange(a);
            if (a.equals(b)) {
                System.out.println(Thread.currentThread().getName() + "相同");
            } else {
                System.out.println(Thread.currentThread().getName() + "不相同");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {

    private Exchanger<String> exchanger;

    public ThreadB(Exchanger<String> exchanger) {
        this.setName("B");
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        String b = "我是Java代码";
        try {
            String a = exchanger.exchange(b);
            if (b.equals(a)) {
                System.out.println(Thread.currentThread().getName() + "相同");
            } else {
                System.out.println(Thread.currentThread().getName() + "不相同");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
