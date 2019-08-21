package com.tengxt.springbootemail.img;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * 带有静态资源（图片）的邮件
 */
@RestController
@RequestMapping("/email")
public class ImgEmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendImgMail")
    public String sendImgMail(){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("1300230407@qq.com");
            // 标题
            helper.setSubject("一封带有静态资源的邮件");
            // 内容
            helper.setText("<html><body>这是一张图片：<img src='cid:img' width='50%' height='50%'/></body></html>", true);
            // 传入附件
            FileSystemResource fileSystemResource =
                    new FileSystemResource(new File("src\\main\\resources\\static\\img\\6f8a2832ly1fw4n2oxwmgj21hc0u07he.jpg"));
            helper.addInline("img", fileSystemResource);
            javaMailSender.send(message);
            return "发送成功";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }
}
