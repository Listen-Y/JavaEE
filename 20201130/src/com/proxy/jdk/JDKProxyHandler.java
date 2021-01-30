package com.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 15:56
 */
public class JDKProxyHandler implements InvocationHandler {
    private Object target;

    /**
     * 绑定委托对象并返回一个代理类
     *
     * @param target   传入被代理对象
     * @return  返回代理对象
     */
    public Object bind(Object target) {
        this.target = target;
        //取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);   //要绑定接口(这是一个缺陷，cglib弥补了这一缺陷)
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())) {
            System.out.println("------before " + method.getName() + "------");
            Object result = method.invoke(target, args);
            System.out.println("------after " + method.getName() + "------");
            return result;
        } else {
            return method.invoke(target, args);
        }
    }

}
