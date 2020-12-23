package com.webstudy.demo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-14
 * Time: 12:59
 */
@Controller
public class HelloController {

    @RequestMapping("/h1")
    public String test(Model model) {
        model.addAttribute("msg", "hello SpringBoot");
        model.addAttribute("p", "<p>我是p标签中的内容</p>");
        model.addAttribute("list", Arrays.asList("one", "two", "three"));
        return "test";
    }
}
