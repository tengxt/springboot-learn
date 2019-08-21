package com.tengxt.springbootemail.html;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 发送带有HTML格式的邮件
 */
@RestController
@RequestMapping("/email")
public class HtmlEmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendHtmlEmail")
    public String sendHtmlEmail(){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("1300230407@qq.com");
            // 标题
            helper.setSubject("一封带有<b>HTML</b>格式的邮件");
            // 带有HTML格式的内容
            StringBuffer stringBuffer = new StringBuffer("<p>使用<b>SpringBoot</b>发送<strong>HTML</strong>格式的邮件</p>");
            helper.setText(stringBuffer.toString(), true);
            javaMailSender.send(message);
            return "发送成功";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }
}
