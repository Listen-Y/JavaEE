package com.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-02
 * Time: 19:05
 */
public class BetterSyn {

    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.show1();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.show2();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.show3();
            }
        }, "C").start();
    }
}

class Data3 {
    private int data = 0;
    private final Lock lock = new ReentrantLock();
    private final Condition condition1 = lock.newCondition();
    private final Condition condition2 = lock.newCondition();
    private final Condition condition3 = lock.newCondition();

    public void show1() {
        lock.lock();
        try {
            while (data != 0) {
                condition1.await();
            }
            data = 1;
            System.out.println(Thread.currentThread().getName() + ":" + data);
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void show2(){
        lock.lock();
        try {
            while (data != 1) {
                condition2.await();
            }
            data = 2;
            System.out.println(Thread.currentThread().getName() + ":" + data);
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void show3() {
        lock.lock();
        try {
            while (data != 2) {
                condition3.await();
            }
            data = 3;
            System.out.println(Thread.currentThread().getName() + ":" + data);
            data = 0;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
