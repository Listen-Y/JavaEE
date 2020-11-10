package util;

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
 * Date: 2020-10-16
 * Time: 9:56
 */
public class DBUtil {

    private volatile static DataSource dataSource;

    private static DataSource dataSource() {
        //使用单例模式
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                dataSource = new MysqlDataSource();
                ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_10_16?characterEncoding=utf-8&useSSL=true");
                ((MysqlDataSource)dataSource).setUser("root");
                ((MysqlDataSource)dataSource).setPassword("listen");
            }
        }
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
