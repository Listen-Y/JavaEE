package dyAgent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 16:06
 */
//每个代理实例都有一个关联的调用处理程序。
// 在代理实例上调用方法时，该方法调用将被编码并分派到invoke 其调用处理程序的方法。
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        //通过Proxy的静态方法得到代理接口的代理类
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    //实现代理并返回结果
    //其关联的代理实例上调用方法时，将在调用处理程序上调用该方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        //调用invoke方法会经过反射 处理被代理实例中的代码
        Object ret = method.invoke(target, args);
        end(method.getName());
        return ret;
    }

    private void end(String name) {
        System.out.println("[OVER]" + name);
    }

    private void log(String name) {
        System.out.println("[DEBUG]" + name);
    }
}
