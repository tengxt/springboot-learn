package com.tengxt.community.controller;

import com.tengxt.community.bean.User;
import com.tengxt.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showPages(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(null != cookies && cookies.length != 0){
            for (Cookie cookie: cookies) {
                if("token".equals(cookie.getName())){
                    String token = cookie.getValue();
                    User user = userService.fingByToken(token);
                    if(null != user){
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        return "index";
    }
}
