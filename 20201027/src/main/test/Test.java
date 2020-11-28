import mybatis.mapper.UserMapper;
import mybatis.model.User;
import mybatis.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 23:10
 */
public class Test {

    private SqlSession sqlSession = DBUtil.getSqlSession();

    @org.junit.Test
    public void select() {
        for (User user : getUserMapper().select()) {
            System.out.println(user);
        }
        close();
    }

    @org.junit.Test
    public void insert() {
        System.out.println(getUserMapper().insert(new User(99, "tiger", "000")));
        //事务提交, 不提交事务不会操作成功
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void delete() {
        System.out.println(getUserMapper().delete(99));
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void selectOne() {
        User user = getUserMapper().selectOne(99);
        System.out.println(user);
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void update() {
        System.out.println(getUserMapper().update(new User(99, "tigerrr", "111111")));
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void selectUserLike() {
        List<User> list = getUserMapper().selectUserLike("%B%");
        for (User user : list) {
            System.out.println(user);
        }
        close();
    }

    @org.junit.Test
    public void updateByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 99);
        map.put("newName", "frake");
        map.put("newPwd", "000000");
        System.out.println(getUserMapper().updateByMap(map));
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void selectUserById() {
        User user = getUserMapper().selectUserById(99);
        System.out.println(user);
        sqlSession.commit();
        close();
    }

    @org.junit.Test
    public void selectUserById2() {
        User user = getUserMapper().selectUserById2(99);
        System.out.println(user);
        sqlSession.commit();
        close();
    }


    private void close() {
        sqlSession.close();
    }
    private UserMapper getUserMapper() {
        return sqlSession.getMapper(UserMapper.class);
    }
}
