/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 18:15
 */
public class Demo3 {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        threadA.setName("A");
        //如果这样直接start执行 肯定会抛出一个异常 但是执行了setUncaughtExceptionHandler方法
        //重写了uncaughtException就会自动捕捉异常
        threadA.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(ThreadA.currentThread().getName() + " 抛出了异常");
            }
        });
        threadA.start();
    }
}

class ThreadA extends Thread {

    @Override
    public void run() {
        //抛出一个异常
        String s = null;
        s.getBytes();
    }

}
