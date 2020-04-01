package com.hou.web.web01;

import javax.servlet.ServletRegistration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class MyServletConfig {

    //注入servlet
    @Bean
    public ServletRegistrationBean createServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(new MyServlet(), "/user.do");
        return servlet;
    }

    //注入Filter
    @Bean
    public FilterRegistrationBean createFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new MyFilter());
        return filter;
    }

    //注入listener
    @Bean
    public ServletListenerRegistrationBean<MyListener> createListener() {
        ServletListenerRegistrationBean<MyListener> listener = new ServletListenerRegistrationBean<MyListener>();
        return listener;
    }

}
