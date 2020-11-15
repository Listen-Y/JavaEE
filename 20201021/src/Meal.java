import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:47
 */
//菜单的接口, 用于表示菜单具有的功能
public interface Meal {

    public void addItem(Item item);
    public float getCost();
    public void showItem();

}
