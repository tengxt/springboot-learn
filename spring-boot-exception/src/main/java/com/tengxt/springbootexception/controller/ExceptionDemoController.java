package com.tengxt.springbootexception.controller;

import com.tengxt.springbootexception.exception.UserNotExistException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionDemoController {

    @RequestMapping("user/{id:\\d+}")
    public void get(@PathVariable String id){
        throw new RuntimeException("user is not exists");
    }

    /**
     * 自定义异常
     * @param id
     */
    @RequestMapping("user/exception/{id:\\d+}")
    public void getById(@PathVariable String id){
        throw new UserNotExistException(id);
    }
}
