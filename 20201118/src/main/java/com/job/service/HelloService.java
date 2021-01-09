package com.job.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-18
 * Time: 15:04
 */
@Service
public class HelloService {


    //通过这个注解告诉SpringBoot这是一个异步任务
    @Async
    public void work() {
        System.out.println("开启执行任务:" + System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务执行结束:" +  System.currentTimeMillis());
    }
}
