package prototype;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 23:02
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Test
    @Override
    public void draw() {
        System.out.println(" ------------------");
        System.out.println("|                  |");
        System.out.println(" ------------------");
    }

}
