package com.tengxt.springbootemail.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送简单的邮件
 */
@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail(){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(from);
            // 接收地址
            mailMessage.setTo("xxxx@qq.com");
            // 标题
            mailMessage.setSubject("一封简单的邮件");
            // 内容
            mailMessage.setText("使用Spring Boot发送简单邮件。");
            javaMailSender.send(mailMessage);
            return "发送成功";
        } catch (MailException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }
}
