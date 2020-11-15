/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:30
 */
//实现drink的抽象类, 表示drink所具有的功能
public abstract class Drink implements Item {

    @Override
    public abstract String name();

    @Override
    public Packing pack() {
        //drink使用的是bottle包装
        return new Bottle();
    }

    @Override
    public abstract float price();
}
