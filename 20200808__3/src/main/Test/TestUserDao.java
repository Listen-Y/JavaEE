import dao.UserDao;
import util.OrderSystemException;
import model.User;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-09
 * Time: 21:09
 */
public class TestUserDao {

    public static void main(String[] args) throws OrderSystemException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setName("listen");
        user.setPassword("111");
        user.setIsAdmin(0);
        //userDao.addUSer(user);
        //System.out.println(userDao.findUserByName("listen"));
        //System.out.println(userDao.findUserByUserId(1));
    }
}
