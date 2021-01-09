package com.job.controller;

import com.job.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-18
 * Time: 15:40
 */
@RestController
public class MailController {

    @Autowired
    private MailService service;

    @RequestMapping("/send")
    public String send() {
        System.out.println("开始发送时间:" + new Date().toString());
        service.sendSimpleMessage();
        System.out.println("返回响应时间:" + new Date().toString());
        return "Send OK";
    }

    @RequestMapping("/send2")
    public String send2() {
        System.out.println("开始发送时间:" + new Date().toString());
        try {
            int count = 10;
            while (count > 0) {
                service.sendMimeMessage();
                count--;
                Thread.sleep(1000);
            }

        } catch (MessagingException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("返回响应时间:" + new Date().toString());
        return "Send OK";
    }

}
