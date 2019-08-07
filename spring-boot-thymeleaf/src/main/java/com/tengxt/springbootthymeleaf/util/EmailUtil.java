package com.tengxt.springbootthymeleaf.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Map;

@Component
public class EmailUtil {

    private static final Logger logger = LoggerFactory.getLogger(EmailUtil.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String senderMailAddress;

    public void sendSimpleMail(Map<String, Object> valueMap){
        MimeMessage mimeMessage = null;
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            // 设置发件人邮箱
            helper.setFrom(senderMailAddress);
            // 设置收件人邮箱
            helper.setTo((String[])valueMap.get("to"));
            // 设置邮件标题
            helper.setSubject(valueMap.get("title").toString());
            // 设置邮件正文
            helper.setSubject(valueMap.get("content").toString());
            // 添加正文（使用thymeleaf模板）
            Context context = new Context();
            context.setVariables(valueMap);
            String content = this.templateEngine.process("mail", context);
            helper.setText(content, true);
            // 发送邮件
            javaMailSender.send(mimeMessage);
        }  catch (MessagingException e) {
            logger.error("发送邮件抛出了异常，信息为："+ e.getCause());
        }
    }
}
