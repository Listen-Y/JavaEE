package com.listen.controller;


import com.listen.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-07
 * Time: 10:40
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login/{key}")
    public String login(@PathVariable int key, HttpSession session, String username, String password, Model model) {
        if (key == 1) {
            return "login";
        }
        if (!"admin".equals(username) || !"aaa".equals(password)) {
            model.addAttribute("username", "账号错误");
            model.addAttribute("password", "密码有误");
            return "login";
        }
        User user = new User(username, password);
        session.setAttribute("user", user);
        return "home";
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("password", user.getPassword());
        return "home";
    }

    @RequestMapping("/out")
    public String out(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

}
