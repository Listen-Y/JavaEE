public class FactorMethod {
    //工厂模式
    //普通的构造方法可以重载 但是还有局限性 如果我现在需要构造俩个不同要求的对象 但是传的参数类型是一样的 那么普通的重载就解决不了了
    //而工厂模式就是使用一个静态方法 在这个静态方法里去实例化一个对象 然后按要求去设置这个对象 然后返回这个对象
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public static FactorMethod rowIndex(int x, int radius) {
        FactorMethod method = new FactorMethod();
        method.setX(x);
        method.setY((int)(Math.PI / radius));
        return method;
    }
    public static FactorMethod beastIndex(int x, int y) {
        FactorMethod method = new FactorMethod();
        method.setY(y);
        method.setX(x);
        return method;
    }

    public static void main(String[] args) {
        FactorMethod method = FactorMethod.rowIndex(1,1);
        System.out.println(method.getX());
        System.out.println(method.getY());
        System.out.println("======================");
        FactorMethod method1 = FactorMethod.beastIndex(1,1);
        System.out.println(method1.getX());
        System.out.println(method1.getY());
    }
}
