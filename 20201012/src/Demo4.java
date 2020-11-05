/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 18:24
 */
public class Demo4 {

    public static void main(String[] args) {
        //给ThreadB执行一个统一异常处理器
        ThreadB.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName() + " 出现异常我捕获了");
            }
        });

        ThreadB threadB = new ThreadB();
        threadB.setName("B");
        ThreadB threadB1 = new ThreadB();
        threadB1.setName("BB");
        threadB.start();
        threadB1.start();
    }
}

class ThreadB extends Thread {

    @Override
    public void run() {
        //抛出一个异常
        String s = null;
        s.getBytes();
    }

}
