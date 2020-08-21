package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleDao {
    //实现对文章的增删查改

    //添加文章
    public static void articleAdd(Article article) {

        //获得连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "insert into article values(null, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, article.getTitle());
            statement.setString(2, article.getData());
            statement.setInt(3, article.getUserId());
            //执行sql
            int key = statement.executeUpdate();
            if (key != 1) {
                System.out.println("文章插入失败");
            } else {
                System.out.println("文章插入成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUTil.DBUTilCloseAll(connection, statement);
        }
    }

    //删除文章
    public static void articleDelete(Article article) {

        //获取连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "delete from article where id = ?";
        PreparedStatement statement = null;
        try {
            //执行sql
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, article.getId());
            int key = statement.executeUpdate();
            if (key != 1) {
                System.out.println("文章删除失败");
            } else {
                System.out.println("文章删除成功");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUTil.DBUTilCloseAll(connection, statement);
        }

    }

    //查询文章
    public static List<Article> articleSelect(int userId) {

        List<Article> list = new ArrayList<>();
        //获取连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "select * from article where userId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //执行sql
            resultSet = statement.executeQuery();
            //获取资源
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setUserId(resultSet.getInt("userId"));
                list.add(article);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            DBUTil.DBUTilCloseAll(connection, statement, resultSet);
        }
       return list;

    }

    //查询文章正文
    public static Article articleSelectData(int articleId) {

        //获取连接
        Connection connection = DBUTil.DBUTilConnection();
        //拼装sql
        String sql = "select * from article where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //执行sql
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, articleId);
            //获取资源
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setData(resultSet.getString("data"));
                article.setUserId(resultSet.getInt("userId"));
                return article;
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
