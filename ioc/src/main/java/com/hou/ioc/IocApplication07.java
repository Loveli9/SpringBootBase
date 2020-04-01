package com.hou.ioc;

import com.hou.ioc.bean.User;
import com.hou.ioc.customannotation.Employee;
import com.hou.ioc.customannotation.EnableLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @Import :用来导入一个或多个类(加入Spring容器中),
 * 或者导入配置类,配置类中的Bean都会加入Spring容器中
 */
@SpringBootApplication
/*@Import({Yaozhi.class,Dianjia.class,MyConfig.class})*/
@EnableLog(name = "springboot")  //使用此注解,会根据ImportSelector接口实现类中逻辑创建Bean
public class IocApplication07 {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(IocApplication07.class, args);
        Employee employee = (Employee)context.getBeansOfType(Employee.class);
        employee.setId(1);
        employee.setName("hyp");
        System.out.println(context.getBeansOfType(Employee.class));
        System.out.println(employee);
        context.close();
    }

}
