package com.employee.controller;

import com.employee.pojo.Admin;
import com.employee.service.AdminService;
import com.employee.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 11:07
 */
@Controller
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", produces="text/html;charset=utf-8")
    @ResponseBody
    public String login(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        //获取数据
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        if (name == null || name.length() == 0 || password == null || password.length() == 0) {
            return "请填写账号和密码";
        }

        System.out.println("[DEBUG]name+password " + name + password);
        //查找用户
        Admin admin = adminService.query(name);
        if (admin == null) {
            return "账号或密码错误";
        }

        //密码检验
        boolean verify = false;
        try {
            verify = MD5Utils.verify(password, admin.getPassword());
        } catch (Exception e) {
            return "MD5检验异常";
        }
        System.out.println("[DEBUG]verify " + verify);
        return verify ? "OK":"账号或密码错误";
    }
}
