package com.tengxt.springboottesting;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.tengxt.springboottesting.mapper")
public class SpringBootTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestingApplication.class, args);
    }

}
