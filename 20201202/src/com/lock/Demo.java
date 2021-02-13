package com.lock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-02
 * Time: 17:27
 */
public class Demo {

    public static void main(String[] args) {
        Object lock = new Object();
        Thread thread = new Thread(() -> {
            try {
                System.out.println("开始子");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束子");
        });
        thread.start();
        System.out.println("结束主");
    }
}
