package service.orderService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DishDao;
import dao.OrderDao;
import model.Dish;
import model.Order;
import model.User;
import util.OrderSystemException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-20
 * Time: 12:12
 */
public class SelfCountServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Response {
        public int ok;
        public String reason;
        public String countOne;
        public String countTwo;
        public String countThree;
    }

    //统计我的战绩 返回我点的订单数目  店了多少道菜 花了多少钱
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            //检查登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("请先登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("请先登录");
            }
            //查询我点了多少订单
            OrderDao dao = new OrderDao();
            List<Order> orders = dao.findAllOrderByUserId(user.getUserId());
            if (orders == null || orders.size() == 0) {
                throw new OrderSystemException("还未下单, 无战绩");
            }
            //找到每个订单中的每到菜 统计菜的数据和花费了多少钱
            int countDish = 0;
            int countMon = 0;
            for (Order order : orders
                 ) {
                Order detailOrder = dao.findDetailedOrder(order.getOrderId());
                List<Dish> dishList = detailOrder.getDishes();
                countDish += dishList.size();
                //统计钱
                for (Dish dish : dishList
                     ) {
                    countMon += dish.getPrice();
                }
            }
            //查询成功 返回数据
            response.ok = 1;
            response.reason = "";
            response.countOne = String.valueOf(orders.size());
            response.countTwo = String.valueOf(countDish);
            response.countThree = String.valueOf(countMon);
        } catch (OrderSystemException e) {
            //处理异常
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    //返回我的喜欢 就是我最常点的三道爱
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();
        try {
            //检查登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("请先登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("请先登录");
            }
            //查找最喜欢吃的三道菜
            List<Integer> likeDishIds = findThreeLikeDishes(user);
            //遍历找到这三个菜 获取菜的名字
            String[] names = new String[3];
            int index = 0;

            for (Integer id : likeDishIds
                 ) {
                DishDao dishDao = new DishDao();
                Dish dish = dishDao.findDishById(id);
                names[index] = dish.getName();
                index++;
            }
            //获取成功
            response.ok = 1;
            if(names[0] != null) {
                response.countOne = names[0];
            }
            if(names[1] != null) {
                response.countTwo = names[1];
            }
            if(names[2] != null) {
                response.countThree = names[2];
            }
            response.reason = "";
        } catch (OrderSystemException e) {
            //获取失败异常处理
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }

    private List<Integer> findThreeLikeDishes(User user) throws OrderSystemException {

        List<Integer> dishIds = new ArrayList<>();
        //查询我点了的订单
        OrderDao dao = new OrderDao();
        List<Order> orders = dao.findAllOrderByUserId(user.getUserId());
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
        //找到最喜欢的三个
        for (int i = 0; i < 3; i++) {
            Integer firstDishId = mostLikeOne(countDishMap);
            if (firstDishId == null) {
                //说明不够三个我们之间break掉
                break;
            }
            dishIds.add(firstDishId);
            //删除最喜欢的那个 找第二喜欢
            countDishMap.remove(firstDishId);
        }
        return dishIds;

    }

    private Integer mostLikeOne(Map<Integer, Integer> countDishMap) {

        if (countDishMap == null || countDishMap.size() == 0) {
            return null;
        }

        int firstDishId = 0;
        int firstCount = 0;
        for (Map.Entry<Integer, Integer> entry : countDishMap.entrySet()
        ) {
            if (entry.getValue() > firstCount) {
                firstDishId = entry.getKey();
                firstCount = entry.getValue();
            }
        }
        return firstDishId;

    }
}
