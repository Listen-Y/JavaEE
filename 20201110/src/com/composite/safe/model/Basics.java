package com.composite.safe.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 11:25
 */
public abstract class Basics {

    protected String name;

    public Basics(String name) {
        this.name = name;
    }

    abstract String getName();
}
