import cache.dao.UserDao;
import org.apache.ibatis.session.SqlSession;

import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 22:08
 */
public class Service implements Runnable {

    private SqlSession sqlSession;
    private CountDownLatch countDownLatch;

    public Service(SqlSession sqlSession, CountDownLatch countDownLatch) {
        this.sqlSession = sqlSession;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("*****额外线程开始执行*****");
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        System.out.println(mapper.selectUserById(99));
        System.out.println("*****额外线程执行结束*****");
        countDownLatch.countDown();
    }
}
