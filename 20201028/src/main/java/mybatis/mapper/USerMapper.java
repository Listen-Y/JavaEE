package mybatis.mapper;

import mybatis.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-28
 * Time: 10:35
 */
public interface USerMapper {

    List<User> select();

    List<User> selectByLimit(Map<String, Object> map);

    @Select("select * from user where id=#{uid} and name=#{name}")
    //使用常见数据类型, 和String类型必须使用@Param给定别名
    User selectOne(@Param("uid") int id, @Param("name") String name);

    @Update("update user set pwd=#{newPwd} where id=#{id}")
    int update(@Param("id") int id, @Param("newPwd") String newPWd);


    @Insert("insert into user values(#{id}, #{name}, #{pwd})")
    int insert(User user);


    @Delete("delete from user where id=#{id}")
    int delete(@Param("id") int id);
}
