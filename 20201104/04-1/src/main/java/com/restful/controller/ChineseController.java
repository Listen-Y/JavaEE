package com.restful.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 15:49
 */
@RestController
public class ChineseController {

    @RequestMapping(value = "/c1")
    public void c1(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("程序猿");
    }

    @RequestMapping(value = "/c2", produces = "text/html;charset=utf-8")
    public String c2(){
        return "程序媛";
    }

    @RequestMapping(value = "/c3")
    public String c3(){
        return "程序员";
    }
}
