package Dao;

import Model.Mv;
import Util.JDBCUtils;

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
 * Date: 2020-07-31
 * Time: 18:22
 */
public class MvDao {

/*
    private int id;
    private String message;
    private String url;*/

    //上传mv
    public int addMv(Mv mv) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "insert into mv values(null, ?,?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, mv.getMessage());
            statement.setString(2, mv.getUrl());

            //执行sql
            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("上传mv成功");
            } else {
                System.out.println("上传mv失败");
            }
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //通过id找到具体的mv
    public Mv findMvById(int mvId) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from mv where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement  = connection.prepareStatement(sql);
            statement.setInt(1, mvId);
            //执行sql
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Mv mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setMessage(resultSet.getString("message"));
                mv.setUrl(resultSet.getString("url"));
                return mv;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return null;

    }
    //删除mv  删除的同时需要判断喜欢列表里是否有这首歌 如果有的话也应该删除 WAIT
    public int deleteMv(int id) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from mv where id = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //同时我们需要将loveMv中的这首歌也应该删掉
            if (ifHaveLoveMv(id)) {
                //说明loveMv中有这首歌 需要把他删掉
                int ret = removeLoveMvOnDelete(id);
                if (ret != 0) {
                    System.out.println("删除loveMv成功");
                } else {
                    System.out.println("删除loveMv失败");
                }
            } else {
                System.out.println("loveMv无这首歌");
            }
            //在mv表中删掉这首歌
            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("mv删除成功");
            } else {
                System.out.println("mv删除失败");
            }
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //同时应该在loveMv中删除该MvId的mv  WAIT
    public int removeLoveMvOnDelete(int mvId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from loveMv where mvId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, mvId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //删除某个人具体喜欢的loveMV  WAIT
    public int deleteLoveMv(int userId, int mvId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from loveMv where userId = ? and mvId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, mvId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("删除loveMv成功");
            } else {
                System.out.println("删除loveMv失败");
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //获得所有mv
    public List<Mv> getAllMv() {

        List<Mv> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from mv";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            //执行sql
            resultSet  = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Mv mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setMessage(resultSet.getString("message"));
                mv.setUrl(resultSet.getString("url"));
                list.add(mv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;

    }
    //模糊查询所有mv
    public List<Mv> getMvByKeyWord(String keyWords) {

        List<Mv> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from mv where message like '%" + keyWords + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            //执行sql
            resultSet  = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Mv mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setMessage(resultSet.getString("message"));
                mv.setUrl(resultSet.getString("url"));
                list.add(mv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;

    }
    //判断loveMv是否有这首歌
    public boolean ifHaveLoveMv(int mvId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from loveMv where mvId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, mvId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement, resultSet);
        }
        return false;

    }
    //增加loveMv
    public int addLoveMv(int userId, int mvId) {

        if (ifUserHaveLovedMv(userId, mvId)) {
            //说明这首歌已经被我喜欢 无需再次添加
            System.out.println("已经喜欢无需添加");
            return 0;
        }
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into loveMv values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, mvId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("添加loveMv成功");
            } else {
                System.out.println("添加loveMv失败");
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //判断某个用户是否已经喜欢某个mv
    public boolean ifUserHaveLovedMv(int userId, int mvId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from loveMv where userId = ? and mvId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, mvId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return false;

    }

    //获得所有loveMV
    public List<Mv> getAllLoveMv(int userId) {

        List<Mv> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from mv where id in (select mvId from loveMv where userId = ?)";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            //执行sql
            resultSet  = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Mv mv = new Mv();
                mv.setId(resultSet.getInt("id"));
                mv.setMessage(resultSet.getString("message"));
                mv.setUrl(resultSet.getString("url"));
                list.add(mv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;

    }

}
