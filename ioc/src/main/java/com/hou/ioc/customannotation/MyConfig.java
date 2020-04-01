package com.hou.ioc.customannotation;

import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean
    public Employee getOneRunnable() {
        return new Employee();
    }

    @Bean
    public Employee getTwoRunnable() {
        return new Employee();
    }

    @Bean
    public Employee getThreeRunnable() {
        return new Employee();
    }
}
