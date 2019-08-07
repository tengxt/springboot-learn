package com.tengxt.springbootthymeleaf.controller;

import com.tengxt.springbootthymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/index")
    public String index(Model model){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            User user = new User();
            user.setId((long) i);
            user.setName("tengxt" + i);
            user.setAddress("火星" + i);
            users.add(user);
        }
        model.addAttribute("users", users);
        return "index";
    }
}
