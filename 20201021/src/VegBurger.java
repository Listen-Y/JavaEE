/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:32
 */
//汉堡的一个实体类, 表示一个素汉堡
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "VerBurger";
    }

    @Override
    public float price() {
        return (float) 13.14;
    }
}
