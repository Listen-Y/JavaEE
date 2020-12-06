package com.web.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-02
 * Time: 9:47
 */
public class FirstController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        //实现业务操作
        String result = "你好, 我是SpringMVC";
        //实现数据封装
        modelAndView.addObject("msg", result);
        modelAndView.setViewName("test");
        return modelAndView;
    }
}
