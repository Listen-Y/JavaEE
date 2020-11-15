/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:35
 */
//drink的实体类, 表示cock这个饮品
public class Cock extends Drink {
    @Override
    public String name() {
        return "Cock Drink";
    }

    @Override
    public float price() {
        return (float)3.21;
    }
}
