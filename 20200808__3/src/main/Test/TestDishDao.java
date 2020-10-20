import dao.DishDao;
import model.Dish;
import util.OrderSystemException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-09
 * Time: 21:15
 */
public class TestDishDao {

    public static void main(String[] args) throws OrderSystemException {
        DishDao dishDao = new DishDao();
        Dish dish = new Dish();
        dish.setName("猪头肉");
        dish.setPrice(3000);
        //dishDao.addDish(dish);
        //System.out.println(dishDao.findAllDish());
        //dishDao.changeDishPrice(2, 5000);
        //System.out.println(dishDao.findDishById(2));
        dishDao.deleteDish(2);
        //System.out.println(dishDao.findDishById(2));
    }
}
