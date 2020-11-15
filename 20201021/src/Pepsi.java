/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:37
 */
//drink的实体类, 表示Pepsi这个实体饮品
public class Pepsi extends Drink {
    @Override
    public String name() {
        return "Pepsi Drink";
    }

    @Override
    public float price() {
        return (float)2.99;
    }
}
