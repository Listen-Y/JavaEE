package mybatis.mapper;

import mybatis.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 22:57
 */
public interface UserMapper {

    List<User> select();
    int insert(User user);
    int delete(int id);
    User selectOne(int id);
    int update(User user);
    //模糊查询
    List<User> selectUserLike(String value);
    //使用map修改内容
    int updateByMap(Map<String, Object> map);

    User selectUserById(int id);

    User selectUserById2(int id);
}
