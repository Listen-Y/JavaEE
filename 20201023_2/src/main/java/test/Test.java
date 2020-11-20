package test;

import tureStaticAgent.Dao;
import tureStaticAgent.Database;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-23
 * Time: 20:46
 */
public class Test {

    public static void main(String[] args) {
        final Dao dao = new Dao();
        InvocationHandler handler = new InvocationHandler() {

            private Object target = dao;

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method.getName());
                return method.invoke(target, args);
            }
        };

        Database proxy = (Database) Proxy.newProxyInstance(dao.getClass().getClassLoader(),
                dao.getClass().getInterfaces(), handler);

        proxy.delete();
    }
}
