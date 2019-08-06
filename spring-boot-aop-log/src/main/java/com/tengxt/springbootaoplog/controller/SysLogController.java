package com.tengxt.springbootaoplog.controller;

import com.tengxt.springbootaoplog.config.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogController {


    @GetMapping("/one")
    @Log("执行方法一")
    public void methodOne(String name){}

    @GetMapping("/two")
    @Log("执行方法二")
    public void methodTwo() throws InterruptedException{
        Thread.sleep(2000);
    }

    @GetMapping("/three")
    @Log("执行方法三")
    public void methodThree(String name, String age){}
}
