package com.hou.springmvc.config;

import com.hou.springmvc.interceptor.MyHandIerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器,返回注册对象
        InterceptorRegistration registration = registry.addInterceptor(new MyHandIerInterceptor());
        registration.addPathPatterns("/**");//指定拦截模式,可使用正则匹配
    }
}
