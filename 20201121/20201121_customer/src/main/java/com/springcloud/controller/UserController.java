package com.springcloud.controller;

import com.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 15:18
 */
@RestController
public class UserController {

    @Autowired
    private RestTemplate template;

    final String PATH = "http://localhost:8080/";

    @RequestMapping("/all")
    public List<User> all() {
        String path = PATH + "select";
        System.out.println("[DEBUG]" + path);
        return template.getForObject(path, List.class);
    }

    @RequestMapping("/one/{id}")
    public User one(@PathVariable("id")int id) {
        String path = PATH + "query/" + id;
        System.out.println("[DEBUG]" + path);
        return template.getForObject(path, User.class);
    }

    @RequestMapping("/insert")
    public boolean add() {
        String path = PATH + "add" + "?id=0&name=duck&pwd=555555";
        System.out.println("[DEBUG]" + path);
        return template.getForObject(path, boolean.class);
    }
}
