/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 18:31
 */
public class Demo5 {

    public static void main(String[] args) {

        ThreadGroup group = new ThreadGroup("Listen的group") {
            //给这个线程组进行统一异常处理
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                //t表示出现异常的是哪个线程 e表示异常
                super.uncaughtException(t, e);
                System.out.println(t.getName() + " 出现异常我捕获了");
            }
        };

        //创建5个正常线程放到我的线程组中
        MyThread[] myThreads = new MyThread[5];
        for (int i = 0; i < 5; i++) {
            myThreads[i] = new MyThread(group, "线程" + i, "" + i);
            myThreads[i].start();
        }
        //
        MyThread myThread = new MyThread(group, "出错线程001", "ab");
        myThread.start();

    }
}

class MyThread extends Thread {

    private String num;
    public MyThread(ThreadGroup group, String name, String num) {
        super(group, name);
        this.num = num;
    }

    @Override
    public void run() {
        //num为字符串的时候 这里会抛出异常
        int num = Integer.parseInt(this.num);
        while (true) {
            System.out.println(Thread.currentThread().getName() + " 死循环中");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
