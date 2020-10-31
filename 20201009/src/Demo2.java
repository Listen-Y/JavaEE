/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-09
 * Time: 23:23
 */
public class Demo2 {

    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal() {
            @Override
            protected Object initialValue() {
                return "我是默认值";
            }
        };

        if (threadLocal.get() == null) {
            System.out.println("未设置值");
            threadLocal.set("我是菜鸟");
        }
        System.out.println(threadLocal.get());

    }

}
