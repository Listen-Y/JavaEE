import model.User;
import model.UserDao;

public class TestUserDao {
    public static void main(String[] args) {

        User user = new User();
        user.setName("张益达");
        user.setPassword("123465789");
        //UserDao.userDelete(user);
        UserDao.userAdd(user);
        System.out.println(UserDao.userSelect(user.getName()));


    }
}
