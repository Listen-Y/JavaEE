package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-12-03
 * Time: 13:52
 */
public class MapDemo {

    public static void main(String[] args) {
        /*Map<String, String> map = new ConcurrentHashMap<>();*/
        ConcurrentSkipListMap<Object, Object> map = new ConcurrentSkipListMap<>();
        /*
        * ConcurrentSkipListMap是线程安全的有序的哈希表，适用于高并发的场景。
        * ConcurrentSkipListMap和TreeMap，它们虽然都是有序的哈希表。
        * 但是，第一，它们的线程安全机制不同，TreeMap是非线程安全的，
        * 而ConcurrentSkipListMap是线程安全的。
        * 第二，ConcurrentSkipListMap是通过跳表实现的，而TreeMap是通过红黑树实现的。
        * 在4线程1.6万数据的条件下，ConcurrentHashMap 存取速度是ConcurrentSkipListMap 的4倍左右。
        * 但ConcurrentSkipListMap有几个ConcurrentHashMap 不能比拟的优点：
1、ConcurrentSkipListMap 的key是有序的。
2、ConcurrentSkipListMap 支持更高的并发。ConcurrentSkipListMap 的存取时间是log（N），和线程数几乎无关。也就是说在数据量一定的情况下，并发的线程越多，ConcurrentSkipListMap越能体现出他的优势。
在非多线程的情况下，应当尽量使用TreeMap。此外对于并发性相对较低的并行程序可以使用Collections.synchronizedSortedMap将TreeMap进行包装，也可以提供较好的效率。对于高并发程序，应当使用ConcurrentSkipListMap，能够提供更高的并发度。
所以在多线程程序中，如果需要对Map的键值进行排序时，请尽量使用ConcurrentSkipListMap，可能得到更好的并发度。
        * */

        for (int i = 0; i < 20; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(String.valueOf(finalI), UUID.randomUUID().toString().substring(0, 5));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
