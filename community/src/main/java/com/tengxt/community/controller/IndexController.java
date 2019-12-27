package com.tengxt.community.controller;

import com.tengxt.community.bean.User;
import com.tengxt.community.dto.PaginationDTO;
import com.tengxt.community.service.QuestionService;
import com.tengxt.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String showPages(HttpServletRequest request, Model model,
                            @RequestParam(name = "page", defaultValue = "1") Integer page,
                            @RequestParam(name = "size", defaultValue = "5") Integer size){

        User user = (User) request.getSession().getAttribute("user");

        PaginationDTO pagination = questionService.questionDTOList(page, size);

        model.addAttribute("pagination", pagination);

        return "index";
    }
}
