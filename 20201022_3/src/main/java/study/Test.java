package study;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 19:35
 */

class Demo implements Cloneable {
    public String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object clone = null;
        clone = super.clone();
        return clone;
    }
}

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Demo demo = new Demo();
        demo.name = "Listen";
        Demo demo1 = (Demo) demo.clone();
        System.out.println(demo.hashCode());
        System.out.println(demo1.hashCode());
        //demo继承Cloneable返回的clone对象, 不是同一个对象, 但是其属性是相同的,
        System.out.println(demo.name);
        System.out.println(demo1.name);
    }
}
