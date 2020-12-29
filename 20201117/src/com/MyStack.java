package com;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-17
 * Time: 21:14
 */
public class MyStack<T> {

    private List<T> list;

    private final int SIZE = 10;

    public MyStack() {
        this.list = new ArrayList<>(10);
    }

    public MyStack(int size) {
        this.list = new ArrayList<>(size);
    }

    public void push(T t) {
        list.add(t);
    }

    public T peek() {
        return list.get(list.size() - 1);
    }

    public T poll() {
        T ret = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return ret;
    }
}
