package com.proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 15:58
 */
/**
 * 测试类
 */
public class Client {

    public static void main(String[] args) {
        JDKProxyHandler proxy = new JDKProxyHandler();
        UserService userServiceProxy = (UserService) proxy.bind(new UserServiceImpl());
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));
    }
}
