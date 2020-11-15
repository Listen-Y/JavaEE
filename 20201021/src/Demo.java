/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 12:14
 */
public class Demo {

    public static void main(String[] args) {
        Store store = new Store();
        //得到一个蔬菜菜单
        Meal vegMeal = store.getVegMeal();
        //展示vegMeal
        System.out.println("show vegMeal");
        vegMeal.showItem();
        System.out.println("总价: " + vegMeal.getCost());
        System.out.println();
        //得到一个鸡肉菜单
        Meal chiMeal = store.getChiMeal();
        System.out.println("show chiMeal");
        chiMeal.showItem();
        System.out.println("总价: " + chiMeal.getCost());
    }
}
