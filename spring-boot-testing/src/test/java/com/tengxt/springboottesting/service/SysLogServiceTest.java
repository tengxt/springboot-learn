package com.tengxt.springboottesting.service;

import com.tengxt.springboottesting.entity.SysLog;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysLogServiceTest {

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void Test(){
        SysLog sysLog = sysLogService.findByName("tengxt");
        Assert.assertEquals("用户名为：tengxt", "tengxt", sysLog.getUsername());
    }

    @Test
    @Transactional
    public void save(){
        SysLog sysLog = new SysLog();
        sysLog.setUsername("tengxt111");
        sysLog.setOperation("测试");
        sysLog.setTime("111");
        sysLog.setMethod("com.tengxt.springboottesting.service.SysLogServiceTest.save");
        sysLog.setIp("127.0.0.1");
        sysLog.setCreateTime(new Date());
        sysLog.setParams("");
        Integer res = sysLogService.save(sysLog);
        System.out.println("受影响行数:" + res);

    }
}
