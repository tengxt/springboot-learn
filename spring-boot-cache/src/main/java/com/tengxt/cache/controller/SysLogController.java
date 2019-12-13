package com.tengxt.cache.controller;

import com.tengxt.cache.bean.SysLog;
import com.tengxt.cache.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @GetMapping("/log/{id}")
    public SysLog getLog(@PathVariable("id") Integer id){
        return sysLogService.getLogById(id);
    }

    @GetMapping("/log")
    public String updateLog(SysLog sysLog){
        sysLogService.updateLog(sysLog);
        return "修改成功";
    }

    @GetMapping("/delLog")
    public String deleteLog(Integer id){
        sysLogService.deleteLog(id);
        return "删除成功";
    }

    @GetMapping("/log/lastName/{name}")
    public SysLog getLogByName(@PathVariable("name") String name){
        return sysLogService.getSysLogByName(name);
    }
}
