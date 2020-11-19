package prototype;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 23:08
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Test
    @Override
    public void draw() {
        System.out.println(" ----------");
        System.out.println("|          |");
        System.out.println("|          |");
        System.out.println("|          |");
        System.out.println(" ----------");
    }
}
