package com.bridge.model;

import com.bridge.util.Draw;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 21:32
 */
public class GreenCircle implements Draw {

    @Override
    public void draw(int radius, int x, int y) {
        System.out.println(this.getClass().getName() + " " + "radius:" + radius +
                " x=" + x + " y=" + y);
    }
}
