package tureStaticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:45
 */
public class Dao implements Database {

    @Override
    public void add() {
        System.out.println("add数据");
    }

    @Override
    public void delete() {
        System.out.println("delete数据");
    }

    @Override
    public void update() {
        System.out.println("update数据");
    }

    @Override
    public void query() {
        System.out.println("query数据");
    }
}
