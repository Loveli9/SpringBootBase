package com.hou.ioc.config;

import com.hou.ioc.condition.*;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

@SpringBootConfiguration
public class ConditionConfig {

    /**
     * @Conditional:基于条件的自动配置,一般配合Condition接口一起使用 只有满足了实现类中的条件, 即方法返回true, 才会装配, 否则不装配
     * 可作用在方法或者类上,表示对类中所有方法起作用
     * 参数可以是一个实现类,也可以是多个,即同时满足多个条件才会装配,构成一个数组
     * 例如:@Conditional({UTF8Condition.class,GBKCondition.class})
     */
    @Bean
    @Conditional(UTF8Condition.class) //只有满足了类中的某个条件才会创建这个Bean,也可作用在类上
    public EncodingConvert getUTF8Encoding() {
        return new UTF8Encoding();
    }

    @Bean
    @Conditional(GBKCondition.class) //参数是实现了Condition接口的一个实现类,重写方法返回布尔值
    public EncodingConvert getGBKEncoding() {
        return new GBKEncoding();
    }

    //  matchIfMissing=true :表示当此配置没有的时候进行装配
    @Bean //根据配置中属性值装配  ,value=配置key,havingValue为条件,即当key对应值为true时装配
    @ConditionalOnProperty(value = "runnable.enable", havingValue = "true", matchIfMissing = true)
    public Runnable getRunnable() {
        return () -> {
        };
    }

    @Bean    //如果classpath下有com.hou.ioc.bean.User这个类,则进行装配
    @ConditionalOnClass(name = "com.hou.ioc.bean.User")
    public Runnable getUserRunnable() {
        return () -> {
        };
    }

    /**
     * @ConditionalOnBean:
     * 根据容器中是否有某个Bean进行装配
     *
     * @ConditionalOnMissingBean: 根据容器中没有某个Bean进行装配
     */
    @Bean
    @ConditionalOnBean(name = "user")
    public Runnable getBeanRunnable() {
        return () -> {
        };
    }
}
