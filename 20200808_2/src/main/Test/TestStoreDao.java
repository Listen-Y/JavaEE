import dao.StoreDao;
import util.OrderSystemException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-14
 * Time: 16:16
 */
public class TestStoreDao {

    public static void main(String[] args) throws OrderSystemException {
        //long start = System.currentTimeMillis();
        StoreDao dao = new StoreDao();
        /*dao.addHotDish(1,1);
        dao.addHotDish(2,3);
        dao.addHotDish(4,4);*/
        System.out.println(dao.selectAllHot());
        //System.out.println(dao.ifExistsByDishId(3));
        //System.out.println(System.currentTimeMillis() - start + " ms");
        dao.dishCountADD(1);
        dao.dishCountADD(2);
        dao.dishCountADD(4);
        System.out.println(dao.selectAllHot());
    }
}
