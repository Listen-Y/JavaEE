package com.mybatis.demo.controller;

import com.mybatis.demo.Service.UserService;
import com.mybatis.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-16
 * Time: 20:58
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    public String select() {
        return userService.select().toString();
    }

    @RequestMapping("/query/{id}")
    public String query(@PathVariable("id")int id) {
        return userService.query(id).toString();
    }

    @RequestMapping("/add")
    public int add() {
        User user = new User(0, "james", "00000");
        return userService.add(user);
    }

    @RequestMapping("/delete/{id}")
    public int delete(@PathVariable("id")int id) {
        return userService.delete(id);
    }
}
