package transaction.mapper;

import transaction.model.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 10:55
 */
public interface UserMapper {

    List<User> selectUser();

    int addUser(User user);

    int deleteUser(int id);
}
