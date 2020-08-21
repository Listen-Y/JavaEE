package model;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    //实现对user的增删查改

    //添加user
    public static void userAdd(User user) {
        //获取数据库连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "insert into user values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            //执行sql
            int key = 0;
            try {
                key = statement.executeUpdate();
            } catch (MySQLIntegrityConstraintViolationException e) {
                System.out.println("账户重复");
            }
            if (key == 1) {
                System.out.println("用户插入成功");
            } else {
                System.out.println("用户插入失败");
            }
            //关闭资源
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUTil.DBUTilCloseAll(connection, statement);
        }

    }

    //删除user
    public static void userDelete(User user) {

        //获得连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "delete from user where name = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            //执行sql
            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUTil.DBUTilCloseAll(connection, statement);
        }

    }

    //查询user
    public static User userSelect(String userName) {

        //获得连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "select * from user where name = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            //执行sql
             resultSet = statement.executeQuery();
            //获取资源
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
            //关闭资源
            DBUTil.DBUTilCloseAll(connection, statement, resultSet);
        }
        return null;

    }
}
