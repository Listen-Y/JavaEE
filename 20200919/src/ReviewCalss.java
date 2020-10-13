/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-19
 * Time: 11:19
 */


class Cat {
    public String name;
    public int age;
}
public class ReviewCalss {

    public static void main(String[] args) throws ClassNotFoundException {
        //通过forName获取
        Class c1 = Class.forName("Cat");
        //通过.class获取 每一个类都会有一个静态属性class
        Class c2 = Cat.class;
        //实例的.getClass获取 说明每一个实例都会有一个getClass方法
        Cat cat = new Cat();
        Class c3 = cat.getClass();
        System.out.println(c1 == c2);
        System.out.println(c2 == c3);

    }
}
