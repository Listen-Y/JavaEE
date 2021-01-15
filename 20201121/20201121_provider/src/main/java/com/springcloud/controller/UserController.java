package com.springcloud.controller;

import com.springcloud.pojo.User;
import com.springcloud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 14:53
 */
@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @RequestMapping("/select")
    public List<User> select() {
        return service.selectAll();
    }

    @RequestMapping("/query/{id}")
    public User query(@PathVariable("id")int id) {
        return service.query(id);
    }

    @RequestMapping("/add")
    public boolean add(User user) {
        System.out.println("[DEBUG]" + user);
        return service.add(user);
    }

    @RequestMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")int id) {
        return service.delete(id);
    }

}
