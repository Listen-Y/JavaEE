package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-01
 * Time: 16:48
 */
@Controller
public class HelloController {


    @RequestMapping("/hello")
    public String hello(Model model) {
        //封装数据, 想模型中添加数据, 可以在jsp页面中加载出来
        model.addAttribute("msg", "hello SpringMVC");

        return "hello"; //会被视图解析器处理
    }
}


