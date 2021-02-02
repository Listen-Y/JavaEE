package com.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-01
 * Time: 17:05
 */
public class DemoPool {

    public static void main(String[] args) {
        ExecutorService pool1 = Executors.newFixedThreadPool(5);

        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        ExecutorService pool3 = Executors.newCachedThreadPool();

        /*
                              int corePoolSize,//核心线程数
                              int maximumPoolSize,//最大线程数
                              long keepAliveTime,//非核心线程的保活时间
                              TimeUnit unit,//时间单位
                              BlockingQueue<Runnable> workQueue, //任务队列
                              ThreadFactory threadFactory, //线程构建工厂
                              RejectedExecutionHandler handler //拒绝策略
         */
/*        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.MINUTE,
                );*/

        //创建任务去线程池中执行
        try {
            for (int i = 0; i < 5; i++) {
                pool1.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getId() + "OK");
                    }
                });
            }
        } finally {
            //线程池必须关闭
            pool1.shutdown();
        }
    }
}
