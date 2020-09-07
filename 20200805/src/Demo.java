import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-05
 * Time: 15:34
 */
public class Demo {

    static class MyThread implements Callable<String> {

        private int ticket = 10;
        @Override
        public String call() throws Exception {
            while (this.ticket > 0) {
                System.out.println("余票为:" + this.ticket--);
            }
            return "票空";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> task = new FutureTask<>(new MyThread());
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
        thread.start();
        thread1.start();
        //get方法会阻塞 直到task运行结束
        System.out.println(task.get());

    }

}
