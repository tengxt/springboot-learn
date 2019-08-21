package com.tengxt.springbootemail.attach;

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
 * 发送带有附件的邮件
 */
@RestController
@RequestMapping("/email")
public class AttachEmailController {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/sendAttachEmail")
    public String sendAttachMail(){
        MimeMessage message = null;
        try {
            message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            // 接收地址
            helper.setTo("1300230407@qq.com");
            // 标题
            helper.setSubject("一封带附件的邮件");
            // 内容
            helper.setText("详情参考附件内容");
            // 传入附件
            FileSystemResource fileSystemResource =
                    new FileSystemResource(new File("src\\main\\resources\\static\\附件.docx"));
            helper.addAttachment("附件.docx", fileSystemResource);
            javaMailSender.send(message);
            return "发送成功";
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "发送失败";
    }
}
