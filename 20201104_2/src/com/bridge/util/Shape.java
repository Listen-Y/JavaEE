package com.bridge.util;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 21:33
 */
public abstract class Shape {

    protected Draw draw;

    public Shape(Draw draw) {
        this.draw = draw;
    }


    public abstract void drawing();
}
