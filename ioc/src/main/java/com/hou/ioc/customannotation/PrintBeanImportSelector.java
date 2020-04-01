package com.hou.ioc.customannotation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 获取注解参数值.将值转换为数组,注入到Bean中,并将Bean注入Spring容器中
 */
public class PrintBeanImportSelector implements ImportBeanDefinitionRegistrar {

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry register) {
        //获取注解中的属性集合map
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(Enableprint.class.getName());
        //获取注解中的packages数组值
        String[] packages = (String[]) annotationAttributes.get("packages");
        //将值转化为list注入PrintBeanPostProcessor中
        List<String> list = Arrays.asList(packages);
        //获取PrintBeanPostProcessor的注入对象Builder类
        BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(PrintBeanPostProcessor.class);
        bdb.addPropertyValue("packages", list);//往Bean中注入list属性
        //手动注入Bean
        register.registerBeanDefinition(PrintBeanPostProcessor.class.getName(), bdb.getBeanDefinition());

    }

}
