package dao;

import util.DBUtil;
import model.Dish;
import util.OrderSystemException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-09
 * Time: 9:34
 */
public class DishDao {

    // 操作菜品表.
// 1. 新增菜品
// 2. 删除菜品
// 3. 查询所有菜品
// 4. 查询指定菜品
// 修改菜品信息, 也是可以支持的. (主要就是改价格)
    public void addDish(Dish dish) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into dish values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, dish.getName());
            statement.setInt(2, dish.getPrice() * 100);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("增加菜品失败");
            }
            System.out.println("插入菜品成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public void deleteDish(int dishId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "delete from dish where dishId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("删除菜品失败");
            }
            System.out.println("增加菜品成功");
        } catch (SQLException e) {
            throw new OrderSystemException("删除失败, 已被下单");
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    public List<Dish> findAllDish() {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from dish";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Dish> dishes = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            dishes = new ArrayList<>();
            while (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                dishes.add(dish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return dishes;
    }

    public Dish findDishById(int dishId) {

        Connection connection = DBUtil.getConnection();
        String sql = "select * from dish where dishId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Dish dish = new Dish();
                dish.setDishId(resultSet.getInt("dishId"));
                dish.setName(resultSet.getString("name"));
                dish.setPrice(resultSet.getInt("price"));
                return dish;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return null;

    }

    public void changeDishPrice(int dishId, int newPrice) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "update dish set price = ? where dishId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, newPrice);
            statement.setInt(2, dishId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改价格失败");
            }
            System.out.println("修改价格成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
