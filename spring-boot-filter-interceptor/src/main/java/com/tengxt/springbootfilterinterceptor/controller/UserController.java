package com.tengxt.springbootfilterinterceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id:\\d+}")
    public void get(@PathVariable String id){
        System.out.println(id);
        //throw new RuntimeException("user not exist");
    }
}
