import dao.OrderDao;
import model.Dish;
import model.Order;
import util.OrderSystemException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-20
 * Time: 14:00
 */
public class TestCount {

    public static void main(String[] args) throws OrderSystemException {
        //查询我点了的订单
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.findAllOrderByUserId(1);
        if (orders == null || orders.size() == 0) {
            throw new OrderSystemException("还未下单唉,我怎么知道你的喜好呢");
        }
        //遍历订单统计
        Map<Integer, Integer> countDishMap = new HashMap<>();
        for (Order o : orders
        ) {
            Order detailOrder = dao.findDetailedOrder(o.getOrderId());
            List<Dish> dishList = detailOrder.getDishes();
            for (Dish dish : dishList
            ) {
                countDishMap.put(dish.getDishId(), countDishMap.getOrDefault(dish.getDishId(), 0) +1);
            }
        }

        System.out.println(countDishMap);
    }

}
