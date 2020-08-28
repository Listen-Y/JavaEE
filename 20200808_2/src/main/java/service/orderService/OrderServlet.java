package service.orderService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.OrderDao;
import model.Dish;
import model.Order;
import model.User;
import util.OrderSystemException;
import util.OrderSystemUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-18
 * Time: 16:53
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private Gson gson = new GsonBuilder().create();

    static class Request {

    }

    static class Response {
        public int ok;
        public String reason;
    }

    //新增订单
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
            //管理员不可下订单的
            if (user.getIsAdmin() == 1) {
                throw new OrderSystemException("管理员不可下订单");
            }
            //解析body
            String jsonStr = OrderSystemUtil.readBody(req);
            //获得body数据
            Integer[] dishIds = gson.fromJson(jsonStr, Integer[].class);
            //如果没有选菜不可以下单
            if (dishIds == null || dishIds.length == 0) {
                throw new OrderSystemException("未选菜, 或点击菜单刷新");
            }
            //数据库处理
            //制作一个订单
            Order order = new Order();
            order.setUserId(user.getUserId());
            List<Dish> list = new ArrayList<>();
            for (Integer i : dishIds
                 ) {
                Dish dish = new Dish();
                dish.setDishId(i);
                list.add(dish);
            }
            order.setDishes(list);
            //订单制作完成 插入这个订单
            OrderDao orderDao = new OrderDao();
            orderDao.addOrder(order);
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            //插入异常
            response.reason = e.getMessage();
            response.ok = 0;
        } finally {
            //返回json结果
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }

    }

    //查看订单 或者查看指定的订单 只需判断我们的get请求后面有没有带OrderId
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Order> orders = new ArrayList<>();
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
            //如果有oderId说明是在查看具体的一个订单 如果没有就是在查看所有订单
            String orderIdStr = req.getParameter("orderId");
            OrderDao orderDao = new OrderDao();
            if (orderIdStr == null) {
                //说明获取所有订单
                //判断是管理员还是非管理员
                if (user.getIsAdmin() == 1) {
                    //管理员获取所有订单
                    orders = orderDao.findAllOrder();
                } else {
                    //非管理员只能获取自己的订单
                    orders = orderDao.findAllOrderByUserId(user.getUserId());
                }
                //返回json数据
                String jsonStr = gson.toJson(orders);
                resp.getWriter().write(jsonStr);
            } else {
                //说明在获取一个具体的订单
                Order order = orderDao.findDetailedOrder(Integer.parseInt(orderIdStr));
                if (user.getIsAdmin() == 0 && order.getUserId() != user.getUserId()) {
                    //说明查看的不是一个用户的订单 我们应该报错
                    throw new OrderSystemException("无权访问该订单");
                }
                //返回json数据
                String jsonStr = gson.toJson(order);
                resp.getWriter().write(jsonStr);
            }
        } catch (OrderSystemException e) {
            // 5. 处理异常情况 返回一个空的链表
            String jsonString = gson.toJson(orders);
            resp.getWriter().write(jsonString);
        }
    }

    //修改订单状态

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Response response = new Response();

        try {
            //查看是否是登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("请先登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("请先登录");
            }
            //只有管理员才可以修改订单状态
            if (user.getIsAdmin() == 0) {
                //不是管理员
                throw new OrderSystemException("非管理员不可修改订单状态");
            }
            //数据库处理
            //获取参数
            String orderId = req.getParameter("orderId");
            String isDone = req.getParameter("isDone");
            if (orderId == null || isDone == null) {
                throw new OrderSystemException("参数错误");
            }
            OrderDao orderDao = new OrderDao();
            orderDao.changeOrderState(Integer.parseInt(orderId), Integer.parseInt(isDone));
            //设置返回数据
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            //异常处理
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //返回json结果
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);

        }

    }

    //进行删除订单操作

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            //判断是不是管理员
            if (user.getIsAdmin() == 0) {
                //不是管理员
                throw new OrderSystemException("非管理员不可删除订单");
            }
            //获得删除订单的订单号
            String orderIdStr = req.getParameter("orderId");
            if (orderIdStr == null) {
                throw new OrderSystemException("数据错误");
            }
            //找到这个订单查看是否已经完成该订单
            int orderId = Integer.parseInt(orderIdStr);
            OrderDao dao = new OrderDao();
            Order order = dao.findDetailedOrder(orderId);
            if (order == null) {
                throw new OrderSystemException("数据错误");
            }
            if (order.getIsDone() == 0) {
                //该订单还未完成
                throw new OrderSystemException("该订单还未完成");
            }
            //进行删除订单操作
            dao.deleteOrder(orderId);
            //删除成功
            response.ok = 1;
            response.reason = "";
        } catch (OrderSystemException e) {
            //删除失败
            response.ok = 0;
            response.reason = e.getMessage();
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(response);
            resp.getWriter().write(jsonStr);
        }
    }
}
