package com.demo;

import com.bridge.model.BlackCircle;
import com.bridge.model.GreenCircle;
import com.bridge.model.RedCircle;
import com.bridge.util.Circle;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-08
 * Time: 20:44
 */
public class Demo {

    public static void main(String[] args) {
        Circle circle = new Circle(new RedCircle(), 5,2, 0, Circle.DRAW_BOOK);
        circle.drawing();

        Circle circle1 = new Circle(new GreenCircle(), 5,2, 0, Circle.DRAW_PAPER);
        circle1.drawing();

        Circle circle2 = new Circle(new BlackCircle(), 5,2, 0, Circle.DRAW_ANYWHERE);
        circle2.drawing();

    }
}
