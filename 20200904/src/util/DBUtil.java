package util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static String url ="jdbc:mysql://127.0.0.1:3306/river_control?characterEncoding=utf-8&useSSL=true";
    private static String username = "root";
    private static String password = "listen";

    private static volatile DataSource DATASOURCE;

    private static DataSource getDATASOURCE() {
        //双层校验锁

        if(DATASOURCE == null){
            synchronized (DBUtil.class){
                if(DATASOURCE == null){
                    DATASOURCE = new MysqlDataSource();
                    ((MysqlDataSource)DATASOURCE).setUrl(url);
                    ((MysqlDataSource)DATASOURCE).setUser(username);
                    ((MysqlDataSource)DATASOURCE).setPassword(password);
                }
            }
        }
        return DATASOURCE;
    }

    public static Connection getConnect(){
        try{
            //从池子中获取连接
            Connection connection = getDATASOURCE().getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("获取数据库连接失败！");
        }
    }

    //断开连接
    public static void getClose(Connection connection,
                                PreparedStatement statement,
                                ResultSet resultSet){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
