package tureStaticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:44
 */
public class Service1 {

    private DaoProxy daoProxy;

    public Service1() {
        daoProxy = new DaoProxy();
    }

    public void add() {
        daoProxy.add();
    }

    public void delete() {

        daoProxy.delete();
    }

    public void update() {

        daoProxy.update();
    }

    public void query() {

        daoProxy.query();
    }
}
