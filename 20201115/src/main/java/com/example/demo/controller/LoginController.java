package com.example.demo.controller;

import com.example.demo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-15
 * Time: 12:55
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestParam("username")String name,
                        @RequestParam("password")String pwd,
                        Model model) {
        if (name.equals(pwd)) {
            //说明账号密码正确
            User user = new User(name, pwd);
            session.setAttribute("user", user);
            model.addAttribute("msg", name);
            return "home";
        } else {
            //说明账号密码不正确
            model.addAttribute("msg", "账号或密码不正确");
            return "index";
        }
    }

    //如果不进行登录, 这个路径的请求应该被拦截器拦截下来
    @RequestMapping("home")
    public String home() {
        return "home";
    }
}
