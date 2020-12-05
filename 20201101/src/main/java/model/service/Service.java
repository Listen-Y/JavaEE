package model.service;

import model.dao.Database;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-01
 * Time: 13:12
 */
public class Service {

    public String check(String username, String password) {
        String response = "";
        if (username!= null && password != null && !username.equals("") && !password.equals("")) {
            if (username.equals(Database.username)&& password.equals(Database.password)) {
                response = "登录成功!!";
            } else {
                response = "账号密码错误";
            }
        } else {
            response = "请出入账号或者密码";
        }
        return response;

    }

}
