package com.restful.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 15:29
 */
@Controller
public class AnswerController {

    @RequestMapping("/a1")
    public ModelAndView a1(ModelAndView modelAndView) {
        modelAndView.addObject("msg", "你好");
        modelAndView.setViewName("test");
        return modelAndView;
    }

    @RequestMapping("/a2")
    public void a2(HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("lam servlet out 哈哈");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/a3")
    public void a3(HttpServletResponse response) {
        try {
            response.sendRedirect("./index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/a4")
    public void a4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "l am coming");
        request.getRequestDispatcher("/WEB-INF/jsp/test.jsp").forward(request, response);
    }
}
