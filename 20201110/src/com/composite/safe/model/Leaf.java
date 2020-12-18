package com.composite.safe.model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-10
 * Time: 11:29
 */
public class Leaf extends Basics {

    public Leaf(String name) {
        super(name);
    }

    @Override
    String getName() {
        return this.name;
    }
}
