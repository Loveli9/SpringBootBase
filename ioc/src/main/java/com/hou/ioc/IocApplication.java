package com.hou.ioc;

import com.hou.ioc.bean.Dept;
import com.hou.ioc.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @SpringBootApplication
 * @ComponentScan
 * @EnableAutoConfiguration 三个注解效果相同
 * 加上注解会自动扫描当前包以及子包下面的bean,
 * 即使配置类中没有配置,也能从容器中获取到,但是Bean类需要加@Component等注解
 */
@SpringBootApplication
public class IocApplication {

    public static void main(String[] args) {
        //运行容器
        ConfigurableApplicationContext context = SpringApplication.run(IocApplication.class, args);//启动
        //Runnable runnable = (Runnable) context.getBean("runnable");//根据名字获取时,配置Bean需要指定名字
        //runnable.run();
        User bean = (User) context.getBean("user");
        Dept dept = (Dept) context.getBean(Dept.class);
        System.out.println("初始化时间"+dept.getInitTime());
        System.out.println("初始name"+dept.getName());
        System.out.println("初始money"+dept.getMoney());
        System.out.println("初始化pi"+dept.getPi());
        System.out.println("初始化nameup"+dept.getNameUp());
        System.out.println(bean);
        context.close();
    }
}
