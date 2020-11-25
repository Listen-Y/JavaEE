package com.employee.service;

import com.employee.pojo.Admin;
import com.employee.utils.MD5Utils;
import junit.framework.TestCase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-25
 * Time: 9:36
 */
public class AdminServiceImplTest extends TestCase {



    public void testQuery() throws Exception {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        AdminService adminService = applicationContext.getBean("adminServiceImpl", AdminService.class);
        Admin admin = adminService.query("admin");
        System.out.println(MD5Utils.verify("123456", admin.getPassword()));


    }
}