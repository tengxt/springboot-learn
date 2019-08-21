package com.tengxt.springbootemail.temp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 使用模板发送邮件
 */
@RestController
@RequestMapping("/email")
public class TempEmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendTempMail")
    public String sendTempMail(String code){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("xxxx@qq.com");
            // 标题
            helper.setSubject("一封带有静态资源的邮件");
            // 出来邮件模板
            Context context = new Context();
            context.setVariable("code", code);
            String template = templateEngine.process("emailTemplate", context);
            helper.setText(template, true);
            javaMailSender.send(message);
            return "发送成功";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }
}
