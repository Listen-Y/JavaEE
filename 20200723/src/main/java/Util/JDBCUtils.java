package Util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-24
 * Time: 16:01
 */
public class JDBCUtils {

    private static DataSource dataSource;

    private static DataSource getDataSource() {

        if (dataSource == null) {
            synchronized (JDBCUtils.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    String url = "jdbc:mysql://127.0.0.1:3306/java_7_24?characterEncoding=utf-8&useSSL=true";
                    ((MysqlDataSource)dataSource).setURL(url);
                    String username = "root";
                    ((MysqlDataSource)dataSource).setUser(username);
                    String password = "listen";
                    ((MysqlDataSource)dataSource).setPassword(password);
                }
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {

        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static void close(Connection connection, PreparedStatement statement, ResultSet resultSet) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void close(Connection connection, PreparedStatement statement) {

        try {
            if (connection != null) {
                connection.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
