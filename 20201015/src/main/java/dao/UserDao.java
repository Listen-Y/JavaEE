package dao;

import mobel.User;
import util.DBUtil;

import java.security.Permission;
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
 * Date: 2020-10-16
 * Time: 10:11
 */
public class UserDao {

    public List<User> selectUser() {
        Connection connection = DBUtil.getConnection();
        String sql = "select * from user";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");
                User user = new User(id, age, name);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection, statement, resultSet);
        }
        return list;
    }

    public boolean insert(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "insert into user(age, name) values(?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getAge());
            statement.setString(2, user.getName());;
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("插入失败");
                return false;
            } else {
                System.out.println("插入成功");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

    public boolean update(User user) {
        Connection connection = DBUtil.getConnection();
        String sql = "update user set age=age*0.5 where id = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, user.getId());
            int ret = statement.executeUpdate();
            if (ret != 1) {
                System.out.println("修改失败");
                return false;
            } else {
                System.out.println("修改成功");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, null);
        }
        return false;
    }

}
