package com.composite.unsafe.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 10:49
 */
public abstract class Basics {

    protected String name;

    public Basics(String name) {
        this.name = name;
    }

    abstract String getName();

    abstract public void add(Basics basics);

    abstract public void remove(Basics basics);

    abstract public void displaySubordinate(int depth);
}
