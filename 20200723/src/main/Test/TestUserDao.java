import Dao.UserDao;
import Model.User;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-28
 * Time: 16:19
 */public class TestUserDao {

    @Test
    public void add() {
        User user = new User();
        user.setId(1);
        user.setName("listen");
        user.setPassword("listen");
        UserDao.addUser(user);
        System.out.println(UserDao.selectUser(user.getName()));*/
    }

    @Test
    public void delete() {
        User user = new User();
        user.setId(1);
        user.setName("listen");
        user.setPassword("listen");
        UserDao.deleteUser(5);
    }
}

