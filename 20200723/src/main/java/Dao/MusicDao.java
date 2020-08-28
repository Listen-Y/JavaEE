package Dao;

import Model.Music;
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
 * Date: 2020-07-24
 * Time: 18:53
 */
public class MusicDao {

    /*
    private int id;
    private String title;
    private String singer;
    private String time;
    private String url;
    private int userId;
    */

    //查询全部歌单
    public static List<Music> selectMusicList() {

        List<Music> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from music";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            //执行sql
            resultSet  = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
      return list;

    }
    //通过歌id查找具体音乐
    public static Music selectMusicById(int musicId) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from music where id = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement  = connection.prepareStatement(sql);
            statement.setInt(1, musicId);
            //执行sql
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                return music;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return null;

    }
    //根据关键词查找歌单
    public static List<Music> selectMusicByKeyWord(String keyWords) {

        List<Music> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from music where title like '%" + keyWords + "%'";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            //执行sql
            resultSet  = statement.executeQuery();
            list = new ArrayList<>();
            while (resultSet.next()) {
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;

    }
    //上传音乐 也就是添加音乐到数据库
    public static int addMusic(Music music) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "insert into music values(null, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setString(1, music.getTitle());
            statement.setString(2, music.getSinger());
            statement.setString(3, music.getTime());
            statement.setString(4, music.getUrl());
            //执行sql
            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("插入音乐成功");
            } else {
                System.out.println("插入音乐失败");
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
    //删除歌曲
    public static int deleteMusicById(int id) {

        //获取连接
        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from music where id = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            //同时我们需要将loveMusic中的这首歌也应该删掉
            if (findLoveMusicById(id)) {
                //说明loveMusic中有这首歌 需要把他删掉
                int ret = removeLoveMusicOnDelete(id);
                if (ret != 0) {
                    System.out.println("删除loveMusic成功");
                } else {
                    System.out.println("删除loveMusic失败");
                }
            } else {
                System.out.println("loveMusic无这首歌");
            }
            //在music表中删掉这首歌
            int key = statement.executeUpdate();
            if (key == 1) {
                System.out.println("music删除成功");
            } else {
                System.out.println("music删除失败");
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
    //查看loveMusic中是否有id这首歌
    private static boolean findLoveMusicById(int id) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from loveMusic where musicId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
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
    //当删除音乐时也需要删除loveMusic表的该歌曲
    public static int removeLoveMusicOnDelete(int musicId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from loveMusic where musicId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, musicId);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //添加音乐到我喜欢列表
    public static int insertLoveMusic(int userId,int musicId) {

        if (findMusicByMusicId(userId, musicId)) {
            //说明这首歌已经被我喜欢 无需再次添加
            System.out.println("已经喜欢无需添加");
            return 0;
        }
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into loveMusic values(null, ?, ?)";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("添加love成功");
            } else {
                System.out.println("添加love失败");
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //移除当前用户喜欢的这首音乐，因为同一首音乐可能多个用户喜欢，所以需要传入当前用户的id
    public static int removeLoveMusic(int userId,int musicId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "delete from loveMusic where userId = ? and musicId = ?";
        PreparedStatement statement = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
            int ret = statement.executeUpdate();
            if (ret == 1) {
                System.out.println("删除loveMusic成功");
            } else {
                System.out.println("删除loveMusic失败");
            }
            return ret;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection, statement);
        }
        return 0;

    }
    //添加喜欢的音乐的时候，需要先判断该音乐是否已经在喜欢音乐里面
    public static boolean findMusicByMusicId(int userId,int musicId) {

        Connection connection = JDBCUtils.getConnection();
        String sql = "select * from loveMusic where userId = ? and musicId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            assert connection != null;
            statement = connection.prepareStatement(sql);
            statement.setInt(1, userId);
            statement.setInt(2, musicId);
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
    //查询用户喜欢的全部歌单
    public static List<Music> findAllLoveMusic(int userId) {

        List<Music> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select * from music where id in (select musicId from loveMusic where userId = ?)";
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
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                list.add(music);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭
            JDBCUtils.close(connection, statement, resultSet);
        }
        return list;

    }
    //根据关键字查询喜欢的歌单支持模糊查询
    public static List<Music> findLoveMusicByKeyWord(String str,int userId) {

        List<Music> list = null;
        //获取连接
        Connection connection = JDBCUtils.getConnection();
        //拼装sql
        String sql = "select music.id as id, title, singer, time, url, music.userId from music, loveMusic " +
                "where music.id = loveMusic.musicId and loveMusic.userId = ? and title like '%" + str + "%'";
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
                Music music = new Music();
                music.setId(resultSet.getInt("id"));
                music.setTitle(resultSet.getString("title"));
                music.setSinger(resultSet.getString("singer"));
                music.setTime(resultSet.getString("time"));
                music.setUrl(resultSet.getString("url"));
                list.add(music);
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
