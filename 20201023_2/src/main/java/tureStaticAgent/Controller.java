package tureStaticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:55
 */
public class Controller {

    public static void main(String[] args) {
        Service1 service = new Service1();
        service.add();
        service.delete();
        service.update();
        service.query();
    }

}
