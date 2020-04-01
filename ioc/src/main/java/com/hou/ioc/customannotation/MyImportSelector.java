package com.hou.ioc.customannotation;

import com.hou.ioc.bean.User;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;


/**
 * 用了ImportSelector之后，可以在Annotation上添加一些属性，然后根据属性的不同动态加载不同的bean
 * 可以自定义注解,使用Import导入此类配置,根据注解参数返回具体Bean
 */
public class MyImportSelector implements ImportSelector {

    /**
     * selectImports方法返回值必须是class数组,该class会自动加入Spring容器
     */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /**
         * importingClassMetadata可以获取注解的详细信息,根据信息动态动态配置Bean
         */
        System.out.println(importingClassMetadata.getAnnotationAttributes(EnableLog.class.getName()));
        //返回的数据中才会创建Bean
        return new String[]{User.class.getName()};
    }

}
