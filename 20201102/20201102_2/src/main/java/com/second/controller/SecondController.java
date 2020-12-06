package com.second.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-02
 * Time: 9:53
 */
@Controller
public class SecondController{

    @RequestMapping(value = "/test")
    public String second(Model model) {
        model.addAttribute("msg", "哈哈哈, 我还是SpringMVC");
        return "test";
    }
}
