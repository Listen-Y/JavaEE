package com.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-03
 * Time: 11:10
 */
public class ListDemo {


    /*
    * ConcurrentModificationException 并发修改异常
    */
    public static void main(String[] args) {

        /*List<String> list = new ArrayList<>(); //直接size++肯定不安全*/
/*
        List<String> list = new Vector<>(); //给add方法执行上锁
*/

/*
        List<String> list = Collections.synchronizedList(new ArrayList<>()); //使用了同步代码块
*/
        List<String> list = new CopyOnWriteArrayList<>();  //使用ReentrantLock,
        // 并且在写入时进行了Arrays.copyOf进行了复制, 使其数组长度加一, 然后加载数组的最后一个位置,避免了数据的覆盖
        //读数据的时候, 直接读取原数组中的数据不用上锁, 实现了读写分离


        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }

}
