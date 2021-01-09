package com.job.controller;

import com.job.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-18
 * Time: 15:03
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService service;

    @RequestMapping("/job")
    public String job() {
        service.work();
        return "OK";
    }

}
