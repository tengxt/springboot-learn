package com.tengxt.springbootthymeleaf.controller;

import com.tengxt.springbootthymeleaf.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MailController {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private EmailUtil emailUtil;

    @RequestMapping("/mail")
    public void sendMail(){
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("to", new String[]{"xxxxxxx@qq.com"});
        valueMap.put("title", "测试邮件标题xxxxxxxxxxxxxxx");
        valueMap.put("content", "测试邮件内容xxxxxxxxxxxxx");
        // 调用发送邮件的方法
        emailUtil.sendSimpleMail(valueMap);
    }
}
