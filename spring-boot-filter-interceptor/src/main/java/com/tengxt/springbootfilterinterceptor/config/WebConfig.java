package com.tengxt.springbootfilterinterceptor.config;

import com.tengxt.springbootfilterinterceptor.filter.TimeFilter;
import com.tengxt.springbootfilterinterceptor.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class WebConfig  extends WebMvcConfigurationSupport {

    @Autowired
    private TimeInterceptor timeInterceptor;


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean timeFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);

        List<String> urlList = new ArrayList<>();
        urlList.add("/*");

        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }
}
