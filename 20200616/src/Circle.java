//这是一个circle类
public class Circle {

    //包含圆心位置 半径 颜色
    public int x;
    public int y;
    public int r;
    public String color;

    //构造函数
    public Circle(int x, int y, int r, String color) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.color = color;
    }

    //计算圆周长 2 * PL * r
    public float circumference() {

        return (float) (2 * Math.PI * r);

    }

    //计算圆的面积 PL * r * r
    public float area() {

        return (float) (Math.PI * r * r);

    }
}
