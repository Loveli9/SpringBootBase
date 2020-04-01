package com.hou.ioc;

import com.hou.ioc.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @SpringBootApplication
 * @ComponentScan
 * @EnableAutoConfiguration 三个注解效果相同
 * 加上注解会自动扫描当前包以及子包下面的bean,
 * 即使配置类中没有配置,也能从容器中获取到,但是Bean类需要加@Component等注解
 */
@SpringBootApplication
public class IocApplication01 {

    public static void main(String[] args) {
        //加载多个配置类启动方式
        SpringApplication application = new SpringApplication();
        Set<String> sources = new HashSet<>();//springboot2.x中是String类型
        sources.add(IocApplication01.class.getName());
        application.setSources(sources);//加载配置类名称集合
        ConfigurableApplicationContext context = application.run(args);
        User bean = context.getBean(User.class);
        System.out.println(bean);
        context.close();

    }
}
