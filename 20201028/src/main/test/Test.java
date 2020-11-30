import mybatis.mapper.USerMapper;
import mybatis.model.User;
import mybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-28
 * Time: 10:38
 */
public class Test {

    private SqlSession sqlSession;

    static Logger logger = Logger.getLogger(Test.class);

    @org.junit.Test
    public void test() {
        for (User user : getMapper().select()) {
            System.out.println(user);
        }
        close();
    }

    @org.junit.Test
    public void log4j() {
        logger.debug("进入方法");
        logger.info("开始");
        try {
            throw new Exception("错误");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        //还可以这样使用
        if (logger.isDebugEnabled()) {
            logger.debug("离开方法");
        }
    }

    @org.junit.Test
    public void selectUserByLimit() {
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", 0);
        map.put("pageSize", 2);
        for (User user : getMapper().selectByLimit(map)) {
            System.out.println(user);
        }
        close();
    }

    @org.junit.Test
    public void selectOne() {
        System.out.println(getMapper().selectOne(99, "faker"));
        close();
    }

    @org.junit.Test
    public void update() {
        getMapper().update(99, "66666");
        close();
    }

    @org.junit.Test
    public void insert() {
        getMapper().insert(new User(66, "listen", "1010101"));
        close();
    }

    @org.junit.Test
    public void delete() {
        System.out.println(getMapper().delete(99));
        close();
    }


    private USerMapper getMapper() {
        sqlSession = DBUtil.getSqlSession();
        return sqlSession.getMapper(USerMapper.class);
    }

    private void close() {
        sqlSession.close();
    }
}
