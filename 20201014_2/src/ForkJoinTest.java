import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 19:23
 */
public class ForkJoinTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ThreadA threadA = new ThreadA(countDownLatch);
        threadA.start();
        countDownLatch.await();
        System.out.println(threadA.result);
        System.out.println("使用传统算法需要的时间: " + (System.currentTimeMillis() - start));


        long start2 = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Count1000 count1000 = new Count1000(1, 1000000000);
        Future<Long> futureTask = forkJoinPool.submit(count1000);
        //获取结果
        System.out.println(futureTask.get());
        System.out.println("使用forkJoin算法需要的时间: " + (System.currentTimeMillis() - start2));

    }
}

class Count1000 extends RecursiveTask<Long> {

    //设置阈值
    public static final int Max_EXPR = 1000;
    private int start;
    private int end;

    public Count1000(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        //判断是否需要任务再次分割
        boolean need = (end - start) <= Max_EXPR;
        long result = 0;
        if (need) {
            //说明不需要分割
            for (int i = start; i <= end; i++) {
                 result += i;
            }
        } else {
            //需要分割
            int mid = (start + end) / 2;
            Count1000 count1000Left = new Count1000(start, mid);
            Count1000 count1000Right = new Count1000(mid + 1, end);
            //执行分割任务
            count1000Left.fork();
            count1000Right.fork();
            //获得分割任务的结果
            Long sum1 = count1000Left.join();
            Long sum2 = count1000Right.join();
            result = sum1 + sum2;
        }
        return result;
    }
}

class ThreadA extends Thread {

    public int result = 0;
    private CountDownLatch countDownLatch;

    public ThreadA(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 1000000000; i++) {
            result += i;
        }
        countDownLatch.countDown();
    }
}
