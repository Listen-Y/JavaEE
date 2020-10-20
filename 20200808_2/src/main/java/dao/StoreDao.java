package dao;

import model.HotDish;
import util.DBUtil;
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
 * Date: 2020-09-14
 * Time: 15:57
 */
public class StoreDao {

    //获取hot_store中的所有信息
    public List<HotDish> selectAllHot() {
        //获取数据库连接
        Connection connection = DBUtil.getConnection();
        //拼装sql语句
        String sql = "select * from hot_dish";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<HotDish> hotDishes = new ArrayList<>();
        try {
            //执行sql语句
            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            //遍历结果集
            while (resultSet.next()) {
                HotDish hotDish = new HotDish();
                hotDish.setDishId(resultSet.getInt("dishId"));
                hotDish.setCount(resultSet.getInt("count"));
                hotDishes.add(hotDish);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            DBUtil.close(connection, statement, resultSet);
        }
        return hotDishes;
    }

    //插入一个hotDish
    public void addHotDish(int dishId, int count) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into hot_dish values(?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            statement.setInt(2, count);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }

    //查看某个记录在不在表里
    public boolean ifExistsByDishId(int dishId) {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from hot_dish where dishId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                //说明有
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, resultSet);
        }
        //只要没有返回true就是说明没找到
        return false;
    }

    //修改表中数据count 每次下单一道菜只能下一个 所以count加一就好
    public void dishCountADD(int dishId) throws OrderSystemException {
        Connection connection = DBUtil.getConnection();
        String sql = "update hot_dish set count = count + 1 where dishId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, dishId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new OrderSystemException("修改数据失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
    }
}
