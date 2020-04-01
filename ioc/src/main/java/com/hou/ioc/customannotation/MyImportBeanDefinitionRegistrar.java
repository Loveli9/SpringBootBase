package com.hou.ioc.customannotation;

import com.hou.ioc.bean.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;


public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * BeanDefinitionRegistry可以动态注入Bean
     * BeanDefinitionBuilder可以获取对象信息
     * 同样可以使用Import导入此类配置动态注入Bean
     */
    public void registerBeanDefinitions(AnnotationMetadata arg0, BeanDefinitionRegistry register) {

        //将User加入Spring容器中
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        register.registerBeanDefinition("user", bdb.getBeanDefinition());

    }

}
