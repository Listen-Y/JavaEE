/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 12:12
 */
//菜单的展示
public class Store {

    //构建一个蔬菜菜单
    public Meal getVegMeal() {
        Meal meal = new MealModel();
        meal.addItem(new VegBurger());
        meal.addItem(new Cock());
        return meal;
    }

    //构建一个鸡肉菜单
    public Meal getChiMeal() {
        Meal meal = new MealModel();
        meal.addItem(new ChiBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

}
