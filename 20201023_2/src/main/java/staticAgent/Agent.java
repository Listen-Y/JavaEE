package staticAgent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 10:02
 */
public class Agent implements Lease {

    private Host host;

    public Agent() {
        this.host = new Host();
    }

    @Override
    public void lease() {
        host.lease();
        System.out.println("租金是:" + getRent());
        checkHouse();
        clean();
        sign();
    }

    @Override
    public int getRent() {
        return host.getRent();
    }

    //看房子
    private void checkHouse() {
        System.out.println("检查房屋!!");
    }

    //起草合同
    private void sign() {
        System.out.println("起草合同!!");
    }

    //打扫房屋
    private void clean() {
        System.out.println("打扫房屋!!");
    }
}
