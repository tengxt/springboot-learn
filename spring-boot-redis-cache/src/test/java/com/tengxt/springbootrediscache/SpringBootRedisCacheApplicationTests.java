package com.tengxt.springbootrediscache;

import com.tengxt.springbootrediscache.entity.SysLog;
import com.tengxt.springbootrediscache.service.SysLogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisCacheApplicationTests {

    @Autowired
    private SysLogService sysLogService;

    @Test
    public void contextLoads() {
        SysLog sysLog1 = this.sysLogService.querySysLogById(2);
        System.out.println(sysLog1);


        SysLog sysLog2 = this.sysLogService.querySysLogById(2);
        System.out.println(sysLog2);

        /*int res = sysLogService.update("哈哈哈哈", 1);
        System.out.println("受影响行数：" + res);


        int delRes = sysLogService.delete(1);
        System.out.println("受影响行数：" + delRes);*/
    }

}
