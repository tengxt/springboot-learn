package com.tengxt.springbootjdbctemplatemultidatasource.controller;

import com.tengxt.springbootjdbctemplatemultidatasource.entity.User;
import com.tengxt.springbootjdbctemplatemultidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("queryAllOne")
    public List<User> queryAllOne(){ return userService.queryUser01All(); }

    @GetMapping("/queryAllTwo")
    public List<User> queryAllTwo(){
        return userService.queryUser02All();
    }
}
