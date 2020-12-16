package com.listen.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-07
 * Time: 17:40
 */
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //执行前的拦截, 返回的是false表示拦截, 返回的是true表示不拦截
        System.out.println("=====preHandle======");
        if (request.getSession().getAttribute("user") != null) {
            return true;
        }
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //不能放行, 返回到首页
        response.sendRedirect("../index.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //执行后
        System.out.println("=====postHandle======");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //执行结束后
        System.out.println("=====afterCompletion======");
    }
}
