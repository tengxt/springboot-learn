package com.tengxt.springboottesting.controller;

import com.tengxt.springboottesting.entity.SysLog;
import com.tengxt.springboottesting.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("log/{userName}")
    public SysLog getUserByName(@PathVariable(value = "userName") String userName) {
        return this.sysLogService.findByName(userName);
    }

    @PostMapping("log/save")
    public int save(@RequestBody SysLog log) {
        return this.sysLogService.save(log);
    }
}
