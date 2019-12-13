package com.tengxt.cache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * key的生成器
 */
@Configuration
public class MyCacheConfig {

    @Bean("mykeyGenerator")
    public KeyGenerator keyGenerator(){
        return new KeyGenerator(){
            @Override
            public Object generate(Object o, Method method, Object... params) {
                return method.getName() + "["+ Arrays.asList(params).toString() +"]";
            }
        };
    }

}
