package com.composite.unsafe.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 10:58
 */
public class Leaf extends Basics {

    public Leaf(String name) {
        super(name);
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    public void add(Basics basics) {
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(Basics basics) {
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }

    @Override
    public void displaySubordinate(int depth) {
        //空实现，抛出“不支持请求”异常
        throw new UnsupportedOperationException();
    }
}
