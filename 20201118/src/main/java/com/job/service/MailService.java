package com.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-18
 * Time: 15:27
 */
@Service
public class MailService {

    //注入senderImpl
    @Autowired
    private JavaMailSenderImpl sender;

    @Async
    public void sendSimpleMessage() {

        //实例化一个简单邮件
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        //设置邮件信息
        simpleMailMessage.setFrom("321359027@qq.com");
        simpleMailMessage.setTo("1604053140@qq.com");
        simpleMailMessage.setSubject("紧急通知");
        simpleMailMessage.setText("开个玩笑,哈哈哈");
        //发送
        sender.send(simpleMailMessage);
        System.out.println("[DEBUG]" + simpleMailMessage.getSubject() + ",发送成功");
    }

    @Async
    public void sendMimeMessage() throws MessagingException {

        //实例一个复杂邮件
        MimeMessage mimeMessage = sender.createMimeMessage();
        //true表示如果需要，以多部分模式（支持替代文本，内联元素和附件）
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        //信息构建
        mimeMessageHelper.setSubject("爽娃娃,小哥哥,表这样鸡");
        mimeMessageHelper.setText("<h style='color:red'>宏宇小哥哥,我在214等你回来</h>", true);  //true表示是否以html解析

        //发送附件, 第一个参数表示附件名, 第二个参数为附件
        mimeMessageHelper.addAttachment("小哥哥好坏.png",
                new File("C:\\Users\\Huawei\\Desktop\\timg.jfif"));

        mimeMessageHelper.setFrom("321359027@qq.com");
        mimeMessageHelper.setTo("756687451@qq.com");

        sender.send(mimeMessage);
        System.out.println("[DEBUG]" + mimeMessage.getSubject() + ",发送成功");
    }

}
