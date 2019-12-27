package com.tengxt.community.controller;

import com.tengxt.community.bean.Question;
import com.tengxt.community.bean.User;
import com.tengxt.community.service.QuestionService;
import com.tengxt.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }


    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            HttpServletRequest request,
            Model model){
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);
        if(null == title || "".equals(title.trim())){
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if(null == description || "".equals(description.trim())){
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if(null == tag || "".equals(tag.trim())){
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        User user = (User) request.getSession().getAttribute("user");
        if(null == user){
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        int res = questionService.saveQuestion(question);
        if(res > 0){
            model.addAttribute("success", "发布成功.");
            return "publish";
        }
        return "publish";
    }
}
