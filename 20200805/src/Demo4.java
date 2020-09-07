/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-05
 * Time: 22:30
 */

class Base {
    private String baseDemo = "base";
    public Base() {
        func();
    }

    public void func() {
        System.out.println(baseDemo);
    }
}

public class Demo4 extends Base {

    private String baseDemo = "sub";

    public void func() {
        System.out.println(baseDemo);
    }

    public static void main(String[] args) {
        //很牛掰我擦 输出为null
        Base base = new Demo4();

    }

}
