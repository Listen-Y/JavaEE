package com.proxy.cglib;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 16:28
 */
/**
 * 测试CGLIB
 */
public class Client {

    public static void main(String[] args) {
        CGLIBProxy cglibProxy = new CGLIBProxy();
        UserService userService = (UserService) cglibProxy.getInstance(new UserServiceImpl());
        userService.getName(1);
        userService.getAge(1);
    }
}
