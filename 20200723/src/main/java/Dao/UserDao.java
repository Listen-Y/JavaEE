package Dao;

import Model.User;
import Util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-24
 * Time: 18:30
 */
public class UserDao {

    //实现对user的增加和根据用户名进行查询

    //增加
    public static void addUser(User user) {
        //获取DataSource连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "insert into user values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            //执行sql

            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("用户插入成功");
            } else {
                System.out.println("用户插入失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭

            JDBCUtils.close(connection, statement);
        }
    }

    //根据用户名查找用户对象
    public static User selectUser(String username) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            //执行sql
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return null;

    }

    //根据id删除这个用户
    public static void deleteUser(int id) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from user where id = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("用户删除成功");
            } else {
                System.out.println("用户删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
    }

}
