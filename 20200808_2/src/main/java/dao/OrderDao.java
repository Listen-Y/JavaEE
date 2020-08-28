package dao;

import util.DBUtil;
import model.Dish;
import model.Order;
import util.OrderSystemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-09
 * Time: 15:08
 */
public class OrderDao {

    // 操作订单
// 1. 新增订单
// 2. 查看所有订单(管理员, 商家)
// 3. 查看指定用户的订单(普通用户, 顾客)
// 4. 查看指定订单的详细信息
// 5. 修改订单状态(订单是否已经完成)
// 6. 删除一个订单 (在删除一个订单不光要删除order_user还要删除order_dish)

    //在新增订单中 需要考虑俩张表 一是订单表 二是下单的灭每一个订单里有哪些菜品表
    public void addOrder(Order order) throws OrderSystemException {
        //加入到订单表中
        addOrderUser(order);
        //将订单中的菜品加到表中
        //这里需要考虑出异常 因为订单已经生成 如果菜品没有加进去就会出错 所以需要回滚操作
        //而且这个表里需要订单号 我们得获取这个订单号 而这个订单号是数据库的自增组件生成的
        addOrderDish(order);
    }

    private void addOrderDish(Order order) throws OrderSystemException {
        //将订单中的每一个菜品加到order_dish表中
        Connection connection = DBUtil.getConnection();
        String sql = "insert into order_dish values(?, ?)";
        PreparedStatement statement = null;
        try {
            //关闭自动提交
            assert connection != null;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (Dish dish : order.getDishes()
                 ) {
                statement.setInt(1, order.getOrderId());
                statement.setInt(2, dish.getDishId());
                //addBatch就是加一个()片段 用于我们数据库中的多行插入
                statement.addBatch();
            }
            //去执行sql语句 但是实际上这里并没有去执行因为一开始我们给connection设置了不能提交
            statement.executeBatch();
            System.out.println("order_dish完成");
            //在这里进行了真正提交
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            //插入失败需要一个回滚操作删除order_user中的数据
            deleteOrderUser(order.getOrderId());
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void deleteOrderUser(int orderId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from order_user where orderId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("回滚失败");
            }
            System.out.println("回滚成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void addOrderUser(Order order) throws OrderSystemException {
        //将订单写入到订单表中
        Connection connection = DBUtil.getConnection();
        String sql = "insert into order_user values(null, ?, now(), 0)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            //加上RETURN_GENERATED_KEYS可以返回主键的值
            statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, order.getUserId());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("新增order_user失败");
            }
            //获取返回的主键值
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                //获取数据库返回数据的时候可以使用列序号 我们的orderId是第一列 我们就获取1就好
                order.setOrderId(resultSet.getInt(1));
            }
            System.out.println("新增order_user成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
    }

    public List<Order> findAllOrder() {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from order_user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return orders;
    }

    public List<Order> findAllOrderByUserId(int userId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from order_user where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Order> orders = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();
            orders = new ArrayList<>();
            while (resultSet.next()) {
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setTime(resultSet.getTimestamp("time"));
                order.setIsDone(resultSet.getInt("isDone"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return orders;
    }

    //查询指定某个订单的详细信息
    public Order findDetailedOrder(int orderId) {
        //现根据订单号找到订单
        Order order = buildOrder(orderId);
        //将订单中的所有点的菜品加到订单中 让订单信息完整
        buildOrderDishes(order, orderId);
        return order;
    }

    private void buildOrderDishes(Order order, int orderId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from dish where dishId in " +
                "(select dishId from order_dish where orderId = ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Dish> dishes = new ArrayList<>();
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);

            }
            order.setDishes(dishes);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
    }

    private Order buildOrder(int orderId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from order_user where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Order order = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setUserId(resultSet.getInt("userId"));
                order.setIsDone(resultSet.getInt("isDone"));
                order.setTime(resultSet.getTimestamp("time"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return order;
    }

    public void changeOrderState(int orderId, int isDone) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "update order_user set isDone = ? where orderId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, isDone);
            statement.setInt(2, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改订单状态失败");
            }
            System.out.println("修改订单状态成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void deleteOrder(int orderId) throws OrderSystemException {
        //先删除order_dish中的菜品 因为需要回滚所以我需要把删除的信息记忆下来以防万一
        List<Integer> dishIds = selectDishIdsByOrderId(orderId);
        deleteOrderDish(orderId, dishIds.size());
        //再删除order_user中的数据 还需要进行回滚
        deleteOrderUser(orderId, dishIds);
    }

    private void deleteOrderUser(int orderId, List<Integer> dishIds) {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from order_user where orderId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除order_user失败");
            }
            System.out.println("删除order_user成功");
        } catch (SQLException | OrderSystemException e) {
            e.printStackTrace();
            //无论触发什么错误在这里都需要进行回滚
            goBackDishes(orderId, dishIds);
            System.out.println("回滚order_dish成功");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void goBackDishes(int orderId, List<Integer> dishIds) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into order_dish values(?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            for (int id : dishIds
                 ) {
                statement.setInt(1, orderId);
                statement.setInt(2, id);
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private void deleteOrderDish(int orderId, int size) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from order_dish where orderId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            int ret = statement.executeUpdate();
            if (ret != size) {
                throw new OrderSystemException("删除order_dish失败");
            }
            System.out.println("删除order_dish成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    private List<Integer> selectDishIdsByOrderId(int orderId) {
        List<Integer> dishIds = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        String sql = "select dishId from order_dish where orderId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int dishId = resultSet.getInt("dishId");
                dishIds.add(dishId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return dishIds;
    }


}
