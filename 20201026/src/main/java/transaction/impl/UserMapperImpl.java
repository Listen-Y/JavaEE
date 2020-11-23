package transaction.impl;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import transaction.mapper.UserMapper;
import transaction.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 11:12
 */
public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUser() {

        return super.getSqlSession().getMapper(UserMapper.class).selectUser();
    }

    @Override
    public int addUser(User user) {
        return super.getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return super.getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
