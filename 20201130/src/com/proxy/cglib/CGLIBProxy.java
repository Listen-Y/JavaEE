package com.proxy.cglib;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 16:27
 */
public class CGLIBProxy implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     *
     * @param target  被代理对象
     * @return 代理对象
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("++++++before " + methodProxy.getSuperName() + "++++++");
        System.out.println(method.getName());
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("++++++after " + methodProxy.getSuperName() + "++++++");

        return result;
    }
}
