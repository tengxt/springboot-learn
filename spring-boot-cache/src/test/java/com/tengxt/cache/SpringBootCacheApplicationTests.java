package com.tengxt.cache;

import com.tengxt.cache.bean.SysLog;
import com.tengxt.cache.mapper.SysLogMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCacheApplicationTests {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Autowired
    RedisTemplate redisTemplate; // k-v 都是对象

    @Autowired
    StringRedisTemplate stringRedisTemplate; // k-v 都是字符串

    @Autowired
    RedisTemplate<Object, SysLog> SysLogRedisTemplate;

    /**
     * Redis 常见的五大数据类型
     * String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
     * stringRedisTemplate.opsForValue()【String（字符串）】
     * stringRedisTemplate.opsForList()【List（列表）】
     * stringRedisTemplate.opsForSet()【Set（集合）】
     * stringRedisTemplate.opsForHash()【Hash（散列）】
     * stringRedisTemplate.opsForZSet()【ZSet（有序集合）】
     */
    @Test
    public void test01(){
        // 给Redis中保存数据
        //stringRedisTemplate.opsForValue().append("msg", "Hello");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

    // 测试缓存对象
    @Test
    public void test02(){
        SysLog logs = sysLogMapper.getLogById(2);
        // 默认如果缓存对象，使用jdk序列化机制，序列化后的结果保存到Redis中
        //redisTemplate.opsForValue().set("syslog：01", logs);
        // 一. 将数据以json的方式保存
        //  1. 自己讲对象转成json
        //  2. redisTemplate默认的序列化规则，改变默认的序列化规则
        SysLogRedisTemplate.opsForValue().set("syslog-01", logs);
    }


    @Test
    public void contextLoads() {
        SysLog logs = sysLogMapper.getLogById(2);
        System.out.println(logs);
    }

}
