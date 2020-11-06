import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-12
 * Time: 21:39
 */
public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        //执行的任务
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //执行一个不安全的和一次安全的
                    counter.safe();
                    counter.unSafe();
                }
            }
        };
        //创建多线程执行环境
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(runnable);
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].join();
        }
        //输出执行结果
        System.out.println("安全的 " + counter.getAtomicInteger());
        System.out.println("不安全的 " + counter.getCount());

    }
}

class Counter {
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int count = 0;

    //使用自旋CAS实现安全计数
    public void safe() {
        while (true) {
            int num = atomicInteger.get();
            //compareAndSet就是CAS操作
            //原理就是比较和交换 首先比较此时的num和内存中的num 如果一样将++num写入返回true
            // 如果不一样就不写入返回false
            boolean b = atomicInteger.compareAndSet(num, ++num);
            if (b) {
                break;
            }
        }
    }
    //不安全的++
    public void unSafe() {
        count++;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getCount() {
        return count;
    }
}



