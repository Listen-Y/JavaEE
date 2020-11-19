package prototype;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 23:19
 */
public class ShapeCache {

    private static HashMap<Integer, Shape> shapeCache = new HashMap<>();

    public static Shape getShape(int shapeId){
        Shape shape = shapeCache.get(shapeId);
        //获得的永远是克隆的对象
        try {
            return shape == null ? null : (Shape) shape.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadCache() {
        Rectangle rectangle = new Rectangle();
        rectangle.setId(1);
        Square square = new Square();
        square.setId(2);
        Triangle triangle = new Triangle();
        triangle.setId(3);
        shapeCache.put(rectangle.getId(), rectangle);
        shapeCache.put(square.getId(), square);
        shapeCache.put(triangle.getId(), triangle);
    }

}
