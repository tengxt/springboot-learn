package com.tengxt.springbootmybatismultidatasource.controller;

import com.tengxt.springbootmybatismultidatasource.entity.User;
import com.tengxt.springbootmybatismultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/userAll/one")
    public List<User> userOneAll(){
        return userService.queryUserOneAll();
    }

    @GetMapping("/userAll/two")
    public List<User> userTwoAll() {
        return userService.queryUserTwoAll();
    }
}
