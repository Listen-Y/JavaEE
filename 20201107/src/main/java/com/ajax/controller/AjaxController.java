package com.ajax.controller;

import com.ajax.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-07
 * Time: 10:40
 */
@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/t2")
    public void test2(String name, HttpServletResponse response) throws IOException {
        System.out.println("name: " + name);
        if ("aaa".equals(name)) {
            response.getWriter().write("true");
        } else {
            response.getWriter().write("false");
        }
    }

    @RequestMapping("/t3")
    public List<User> test3() {
        List<User> list = new ArrayList<>();
        list.add(new User(0, "listen", "112233"));
        list.add(new User(1, "bike", "445566"));
        list.add(new User(2, "milk", "778899"));
        return list;
    }

    @RequestMapping("t4")
    public String test4(String username, String password) {
        System.out.println("username" + username + "password" + password + "================");
        String msg = "";
        if (username != null) {
            if ("admin".equals(username)) {
                msg = "OK";
            } else {
                msg = "用户名有误";
            }
        }
        if (password != null) {
            if ("aaa".equals(password)) {
                msg = "OK";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
