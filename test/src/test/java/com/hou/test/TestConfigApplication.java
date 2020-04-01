package com.hou.test;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * 测试配置类: 使用@TestConfiguration注解的配置类
 * 中配置的Bean只在测试环境的容器中,当只需要测试环境的=中配置某些Bean时,
 * 可以使用此注解
 */
@TestConfiguration
public class TestConfigApplication {

    //配置Runnable到容器中
    @Bean
    public Runnable createRunable() {
        return () -> {
        };
    }

}
