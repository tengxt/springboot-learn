package com.tengxt.springbootmybatismultidatasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @ConfigurationProperties(prefix  = "spring.datasource.druid.one")
    @Bean(name = "dsOne")
    DataSource dsOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix  = "spring.datasource.druid.two")
    @Bean(name = "dsTwo")
    DataSource dsTwo(){
        return DruidDataSourceBuilder.create().build();
    }
}
