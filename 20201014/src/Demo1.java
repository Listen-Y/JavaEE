import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 16:57
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        //参数4表示必须受到4次通知才可以
        CountDownLatch countDownLatch = new CountDownLatch(4);
        MyRunnable myRunnableA = new MyRunnable(1, 4, countDownLatch);
        MyRunnable myRunnableB = new MyRunnable(5, 10, countDownLatch);
        //创建线程去执行任务
        Thread a = new Thread(myRunnableA, "A");
        a.start();
        Thread b = new Thread(myRunnableB, "B");
        b.start();
        //在这里进行等待, 直到受到4次通知才不等待
        countDownLatch.await();

        int result = myRunnableA.getResult() + myRunnableB.getResult();
        System.out.println("1~10的和为: " + result);
    }
}

class MyRunnable implements Runnable {

    private int start;
    private int end;
    private int result;
    private CountDownLatch countDownLatch;

    public MyRunnable(int start, int end, CountDownLatch countDownLatch) {
        this.start = start;
        this.end = end;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        //执行一段计算任务
        for (int i = start; i <= end; i++) {
            result += i;
        }
        //通知一次
        countDownLatch.countDown();
        //一个线程可以通知任意次
        countDownLatch.countDown();

    }

    public int getResult() {
        return result;
    }
}
