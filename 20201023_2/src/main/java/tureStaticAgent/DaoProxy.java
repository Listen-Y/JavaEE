package tureStaticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:47
 */
public class DaoProxy implements Database {

    private Dao dao;

    public DaoProxy() {
        this.dao = new Dao();
    }


    @Override
    public void add() {
        journal("add");
        dao.add();
    }

    @Override
    public void delete() {
        journal("delete");
        dao.delete();
    }

    @Override
    public void update() {
        journal("update");
        dao.update();
    }

    @Override
    public void query() {
        journal("query");
        dao.query();
    }

    private void journal(String srt) {
        System.out.println("[DEBUG] 执行了" + srt);
    }
}
