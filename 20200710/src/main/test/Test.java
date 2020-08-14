import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        //创建DataSource对象
        DataSource dataSource = new MysqlDataSource();
        //连接管理
        String url = "jdbc:mysql://127.0.0.1:3306/java_5_31?characterEncoding=utf-8&useSSL=true";
        String userName = "root";
        String password = "listen";
        ((MysqlDataSource)dataSource).setURL(url);
        ((MysqlDataSource)dataSource).setUser(userName);
        ((MysqlDataSource)dataSource).setPassword(password);
        Connection connection = dataSource.getConnection();
        //拼接sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        //执行sql
        //查询使用executeQuery  修改和插入都是使用executeUpdate
        //使用executeQuery 返回的是一个result集合
        //使用executeUpdate返回的是一个修改的数据
        ResultSet resultSet = statement.executeQuery();
        //输出结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int classId = resultSet.getInt("classId");
            System.out.println(id + " " + name + " " + classId);
        }
        //有条件查询
        String sql1 = "select * from student where id = ? and name = ?";
        statement = connection.prepareStatement(sql1);
        statement.setInt(1, 1);
        statement.setString(2, "张翼德");
        ResultSet resultSet1 = statement.executeQuery();
        while (resultSet1.next()) {
            int id = resultSet1.getInt("id");
            String name = resultSet1.getString("name");
            int classId = resultSet1.getInt("classId");
            System.out.println(id + " " + name + " " + classId);
        }
        //关闭资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
