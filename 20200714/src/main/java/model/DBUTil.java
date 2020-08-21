package model;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUTil {
    //使用单例模式与数据库建立连接
    private static volatile DataSource dataSource;

    //通过这个方法获取DataSource对象 并使用锁和volatile保证多线程安全
    private static DataSource DBUTilGetDataSource() {

        if (dataSource == null) {
            synchronized (DBUTil.class) {
                if (dataSource == null) {
                    //与数据库建立连接
                    dataSource = new MysqlDataSource();
                    ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_7_17?characterEncoding=utf-8&useSSL=true");
                    ((MysqlDataSource)dataSource).setUser("root");
                    ((MysqlDataSource)dataSource).setPassword("listen");
                }
            }
        }
        return dataSource;
    }

    //通过这个方法获取数据库connection
    public static Connection DBUTilConnection() {

        try {
            return DBUTil.DBUTilGetDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //用此方法关闭资源 后创建的资源先关闭
    public static void DBUTilCloseAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void DBUTilCloseAll(Connection connection, PreparedStatement statement) {

        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
