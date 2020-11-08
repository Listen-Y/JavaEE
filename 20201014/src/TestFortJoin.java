import sun.util.resources.cldr.te.TimeZoneNames_te;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-14
 * Time: 15:34
 */
public class TestFortJoin {

    public static void main(String[] args) {
        //需要使用ForkJoinPool是执行继承了Task的Counter任务
        ForkJoinPool pool = new ForkJoinPool();
        //生成一个计算任务
        Counter counter = new Counter(1, 4);
        Future<Integer> result = pool.submit(counter);
        //得到结果
        try {
            System.out.println(result.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        //异常处理
        if (counter.isCompletedAbnormally()) {
            System.out.println(counter.getException().getMessage());
        }
    }
}

class Counter extends RecursiveTask<Integer> {

    //设置阈值
    private static final int Max = 2;
    private int start;
    private int end;

    public Counter(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        //抛出异常
        if (false)
        throw new RuntimeException("俺来了");


        int sum = 0;
        //首先判断是否需要任务的再次分割
        if ((end - start) <= Max) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            //说明任务还得继续分割
            int mid = (start + end) / 2;
            Counter left = new Counter(start, mid);
            Counter right = new Counter(mid + 1, end);
            //执行子任务
            left.fork();
            right.fork();
            //等待子任务执行完
            int tmpLeft = left.join();
            int tmpRight = right.join();
            //合并子任务结果
            sum = tmpLeft + tmpRight;
        }
        return sum;
    }
}
