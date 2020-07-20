//这是一个测试类
public class TestCircle {

    public static void main(String[] args) {

        Circle circle = new Circle(0, 0, 3, "red");
        System.out.println(circle.circumference());
        System.out.println(circle.area());

        Circle circle1 = new Circle(0, 0, 5, "bule");
        System.out.println(circle1.circumference());
        System.out.println(circle1.area());

    }
}
