package com.hou.ioc;

import com.hou.ioc.config.DBConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


@SpringBootApplication
public class IocApplication03 {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(IocApplication03.class, args);
        //指定db.yml配置文件
        DBConfig bean = applicationContext.getBean(DBConfig.class);
        System.out.println(bean);
        applicationContext.close();
    }
}
