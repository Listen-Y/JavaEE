package com.test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-03
 * Time: 13:41
 */
public class SetDemo {

    public static void main(String[] args) {
        /*Set<String> stringSet = new HashSet<>();*/
/*
        Set<String> stringSet = Collections.synchronizedSet(new HashSet<>()); //海慧寺使用同步代码块实现
*/

/*
        Set<String> stringSet = new CopyOnWriteArraySet<>(); //和list的相同, 使用ReentrantLock实现同步
        //并且在新增的时候采用复制的方法, 将读写进行分离, 也就是写会加锁, 读不会加锁
        //因为Arrays.copyOf对数租而言是深拷贝, 也就是新建了一个数组, 所以对其进行放数据, 对原来的数据进行读数据
*/

        Set<String> stringSet = new ConcurrentSkipListSet<>();
        /*
        * ConcurrentSkipListSet的底层就是封装着一个ConcurrentSkipListMap
        * */

        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                stringSet.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(stringSet);
            }, String.valueOf(i)).start();
        }
    }
}
