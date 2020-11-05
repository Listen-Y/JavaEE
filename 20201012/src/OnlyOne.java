/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-11
 * Time: 16:32
 */
public class OnlyOne {

    public int id;

    public OnlyOne(int id) {
        this.id = id;
    }
}

class LazyObject {

    private static OnlyOne onlyOne;
    //单例模式中的懒汉模式 就是我需要的时候才去创建这个对象
    public static OnlyOne getInstance() {

        if (onlyOne == null) {
            synchronized (LazyObject.class) {
                if (onlyOne == null) {
                    onlyOne = new OnlyOne(10);
                }
            }
        }
        return onlyOne;
    }
}

class HungryObject {

    private static OnlyOne onlyOne = new OnlyOne(10);

    //饿汗模式 就是我不要他 他就已经创建好了
    public static OnlyOne getInstance() {
        return onlyOne;
    }
}