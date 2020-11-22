package mybatis.mapper;

import mybatis.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-25
 * Time: 14:24
 */
public interface UserMapper {

    List<User> selectUser();
}
