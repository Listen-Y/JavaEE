package com.example.demo.config;

import com.example.demo.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-15
 * Time: 12:46
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获取session, 只要有session就放行
        HttpSession session = request.getSession(false);
        if (session == null) {
            //没有设置session不放行
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            //说明没有登陆不放行
            request.setAttribute("msg", "请登录");
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            //放行
            return true;
        }
    }
}
