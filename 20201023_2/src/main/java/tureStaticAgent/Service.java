package tureStaticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 16:53
 */
public class Service implements Database {


    private Dao dao;

    public Service() {
        dao = new Dao();
    }

    public void add() {
        System.out.println("222");
        dao.add();
    }

    public void delete() {
        System.out.println("111");

        dao.delete();
    }

    public void update() {
        System.out.println("333");

        dao.update();
    }

    public void query() {
        System.out.println("444");

        dao.query();
    }
}
