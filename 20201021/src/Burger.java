/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:17
 */
//创建Burger的抽象类, 用于实现Burger需要的功能
public abstract class Burger implements Item {

    @Override
    public abstract String name();

    @Override
    public Packing pack() {
        //Burger使用的是纸质包装
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
