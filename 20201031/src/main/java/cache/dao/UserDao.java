package cache.dao;

import cache.model.User;
import org.apache.ibatis.annotations.CacheNamespaceRef;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 21:55
 */
public interface UserDao {

    User selectUserById(@Param("id") int id);

    int insert(User user);

    int update(@Param("id") int id);

    @Select("select * from user where id=#{id}")
    User selectOneUser(@Param("id")int id);
}
