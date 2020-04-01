package com.hou.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Condition接口: 监听,只有在满足了一些条件之后才会启用相关配置,
 * 其实现类可作用于@Conditional注解参数中,达到满足条件才初始化Bean等操作
 */
public class UTF8Condition implements Condition {
    /**
     * 逻辑,只有返回true时,才会启用配置
     */
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // file.encoding:  获取java文件编码
        String encoding = System.getProperty("file.encoding");
        if (encoding != null) {
            return "utf-8".equals(encoding.toLowerCase());
        }
        return false;
    }

}
