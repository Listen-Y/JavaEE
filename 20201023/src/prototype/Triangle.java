package prototype;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 23:13
 */
public class Triangle extends Shape {

    public Triangle() {
        type = "Triangle";
    }

    @Test
    @Override
    public void draw() {
        System.out.println("     -");
        System.out.println("    ---");
        System.out.println("   -----");
        System.out.println("  -------");
        System.out.println(" ---------");
        System.out.println("-----------");
    }
}
