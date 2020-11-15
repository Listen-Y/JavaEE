/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:34
 */
//汉堡的实体类, 表示一个鸡肉汉堡
public class ChiBurger extends Burger {
    @Override
    public String name() {
        return "ChiBurger";
    }

    @Override
    public float price() {
        return (float)52.50;
    }
}
