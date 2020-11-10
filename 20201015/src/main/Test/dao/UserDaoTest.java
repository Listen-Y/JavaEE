package dao;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-10-16
 * Time: 11:44
 */
public class UserDaoTest {

    private UserDao dao = new UserDao();

    @Test
    public void selectUser() {

        System.out.println(dao.selectUser());
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }
}