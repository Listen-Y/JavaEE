package dyAgent;

import staticAgent.Host;
import staticAgent.Lease;
import tureStaticAgent.Dao;
import tureStaticAgent.Database;
import tureStaticAgent.Service;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 16:17
 */
public class Demo {

    public static void main(String[] args) {
       //主角
        Service service = new Service();
        //获得动态代理类
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.setTarget(service);
        //我们使用的是JDK中基于接口实现的动态代理, 所以得用接口去接受, 所以上面set进去的一定要实现下面的这个接口
        Database serviceProxy = (Database) handler.getTarget();
        serviceProxy.add();
        serviceProxy.delete();
        serviceProxy.query();
        serviceProxy.update();
    }
}
