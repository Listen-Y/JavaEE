import dao.DishDao;
import dao.OrderDao;
import model.Dish;
import model.Order;
import util.OrderSystemException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-09
 * Time: 21:23
 */
public class TestOrderDao {

    public static void main(String[] args) throws OrderSystemException {
        OrderDao dao = new OrderDao();
        DishDao dishDao = new DishDao();
        Dish dish = dishDao.findDishById(1);
        Dish dish1 = dishDao.findDishById(3);
        Order order = new Order();
        order.setUserId(1);
        List<Dish> dishes = new ArrayList<>();
        order.setDishes(dishes);
        dishes.add(dish);
        dishes.add(dish1);
        //dao.addOrder(order);
        //System.out.println(dao.findAllOrder());
        //System.out.println(dao.findAllOrderByUserId(1));
        //System.out.println(dao.findDetailedOrder(1));
        //System.out.println(dao.findDetailedOrder(3));
        //dao.changeOrderState(1, 1);
        //System.out.println(dao.findAllOrderByUserId(1));
        //dao.deleteOrder(3);
        //System.out.println(dao.findAllOrderByUserId(1));
    }
}
