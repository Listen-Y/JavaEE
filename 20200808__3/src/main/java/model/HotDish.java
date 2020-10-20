package model;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-14
 * Time: 15:59
 */
public class HotDish {

    private int dishId;
    private int count;

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HotDish{" +
                "dishId=" + dishId +
                ", count=" + count +
                '}';
    }
}
