package prototype;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 13:19
 */
public class Demo {

    public static void main(String[] args) {
        ShapeCache.loadCache();
        //获得长方形
        Rectangle rectangle = (Rectangle) ShapeCache.getShape(1);
        System.out.println(rectangle.type + ": ");
        rectangle.draw();
        //获得正方形
        Square square = (Square) ShapeCache.getShape(2);
        System.out.println(square.type + ": ");
        square.draw();
        //获得三角形
        Triangle triangle = (Triangle) ShapeCache.getShape(3);
        System.out.println(triangle.type + ": ");
        triangle.draw();
        //获得长方形
        Rectangle rectangle1 = (Rectangle) ShapeCache.getShape(1);
        System.out.println(rectangle1.type + ": ");
        rectangle1.draw();
    }
}
