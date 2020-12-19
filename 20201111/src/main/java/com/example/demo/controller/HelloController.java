package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-11
 * Time: 16:33
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }
}
