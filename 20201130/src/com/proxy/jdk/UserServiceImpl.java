package com.proxy.jdk;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-11-30
 * Time: 15:55
 */
public class UserServiceImpl implements UserService {

    public String getName(int id) {
        System.out.println("------getName------");
        return "cat";
    }

    public Integer getAge(int id) {
        System.out.println("------getAge------");
        return 10;
    }
}
