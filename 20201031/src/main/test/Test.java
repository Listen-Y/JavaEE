import cache.dao.UserDao;
import cache.model.User;
import cache.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 22:01
 */
public class Test {

    @org.junit.Test
    public void selectById() {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.selectUserById(99));
        System.out.println("********************************");
        System.out.println(mapper.update(99));
        System.out.println("*****修改完毕*****");
        System.out.println(mapper.selectUserById(99));
        sqlSession.close();
    }

    @org.junit.Test
    public void selectById2() throws InterruptedException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.selectUserById(99));

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(new Service(sqlSession, countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println("关闭sqlSession");
        sqlSession.close();
    }

    @org.junit.Test
    public void selectById22() throws InterruptedException {
        SqlSession sqlSession = DBUtil.getSqlSession();
        SqlSession sqlSession1 = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        System.out.println(mapper.selectUserById(99));
        System.out.println("关闭sqlSession");
        sqlSession.close();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread thread = new Thread(new Service(sqlSession1, countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println("关闭sqlSession1");
        sqlSession1.close();
    }


        @org.junit.Test
    public void selectOneUser() {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.selectOneUser(99));
        System.out.println("********************************");
        System.out.println(mapper.selectUserById(99));
        sqlSession.close();
    }

    @org.junit.Test
    public void update() {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.update(99));
        sqlSession.close();
    }

    @org.junit.Test
    public void insert() {
        SqlSession sqlSession = DBUtil.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        User user = new User(11, "mom", "334455");
        System.out.println(mapper.insert(user));
        sqlSession.close();
    }

}
