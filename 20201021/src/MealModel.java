import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 11:56
 */
//表示一个菜单模板
public class MealModel implements Meal{

    private List<Item> items = new ArrayList<>();

    @Override
    public  void addItem(Item item) {
        this.items.add(item);
    }

    @Override
    public float getCost() {
        float ret = 0;
        for (Item item: items
             ) {
            ret += item.price();
        }
        return ret;
    }

    @Override
    public void showItem() {
        for (Item item : items
             ) {
            System.out.println(item.name() + ",  " + item.pack().pack() + ",  " + item.price());
        }
    }

}
