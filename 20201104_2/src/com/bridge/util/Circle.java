package com.bridge.util;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 21:37
 */

public class Circle extends Shape {

    private final int radius;
    private final int x;
    private final int y;
    private final int key;

    public static final int DRAW_PAPER = 1;
    public static final int DRAW_BOOK = 2;
    public static final int DRAW_ANYWHERE = 3;

    public Circle(Draw draw, int radius, int x, int y, int key) {
        super(draw);
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.key = key;
    }

    @Override
    public void drawing() {
        if (key == 1) {
            System.out.println("我在纸上画");
            draw.draw(radius, x, y);
        } else if (key == 2) {
            System.out.println("我在书上画");
            draw.draw(radius, x, y);
        } else {
            System.out.println("我到处画");
            draw.draw(radius, x, y);
        }

    }
}
