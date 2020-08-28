package service.dishService;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.DishDao;
import model.Dish;
import model.User;
import service.userService.RegisterServlet;
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
 * Date: 2020-08-15
 * Time: 21:28
 */
@WebServlet("/dish")
public class DishServlet extends HttpServlet {
    private Gson gson = new GsonBuilder().create();

    static class Request {
        public String name;
        public int price;
    }

    static class Respond {
        public int ok;
        public String reason;
    }

    //新增菜品
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //判断是否为登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //判断是否是管理员只有管理员才可以新增菜品
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("非管理员不可进行此操作");
            }
            //解析body
            String jsonStr = OrderSystemUtil.readBody(req);
            //构建对象
            Request request = gson.fromJson(jsonStr, Request.class);
            //插入到数据库中
            Dish dish = new Dish();
            dish.setName(request.name);
            dish.setPrice(request.price);
            DishDao dishDao = new DishDao();
            dishDao.addDish(dish);
            respond.ok = 1;
            respond.reason = "";
        } catch (OrderSystemException e) {
            //插入失败
            respond.reason = e.getMessage();
            respond.ok = 0;
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }
    }

    //删除菜品
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        Respond respond = new Respond();
        try {
            //判断当前是否是登录状态 还要判断是不是管理员
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("您尚未登录");
            }
            User user = (User)session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("您尚未登录");
            }
            //判断是否是管理员只有管理员才可以新增菜品
            if (user.getIsAdmin() == 0) {
                throw new OrderSystemException("非管理员不可进行此操作");
            }
            //获取要删除的菜的id 还要判断这个id是不是合法
            String dishIdStr = req.getParameter("dishId");
            if (dishIdStr == null) {
                throw new OrderSystemException("数据错误");
            }
            //进行数据库操作
            try {
                DishDao dishDao = new DishDao();
                dishDao.deleteDish(Integer.parseInt(dishIdStr));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            //完成任务
            respond.ok = 1;
            respond.reason = "";
        } catch (OrderSystemException e) {
            //删除失败
            respond.reason = e.getMessage();
            respond.ok = 0;
        } finally {
            //返回json数据
            String jsonStr = gson.toJson(respond);
            resp.getWriter().write(jsonStr);
        }
    }

    //查看所有菜品
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json; charset=utf-8");
        List<Dish> dishes = new ArrayList<>();
        try {
            //判断是否是登录状态
            HttpSession session = req.getSession(false);
            if (session == null) {
                throw new OrderSystemException("请先登录");
            }
            User user = (User) session.getAttribute("user");
            if (user == null) {
                throw new OrderSystemException("请先登录");
            }
            //数据库中查找所有菜品信息
            DishDao dishDao = new DishDao();
            dishes = dishDao.findAllDish();
            //返回json数据
            String jsonStr = gson.toJson(dishes);
            resp.getWriter().write(jsonStr);
        } catch (OrderSystemException e) {
            //不能正常获取资源 返回一个空的链表
            String jsonStr = gson.toJson(dishes);
            resp.getWriter().write(jsonStr);
        }
    }
}
