package com.hou.ioc.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dept {
    /**
     * EL需要用 # ,引入配置文件需要用 $
     * 记录Bean初始化的时间: T()表示引入类,java默认加载类不需要写全路径名
     *                          后面静态方法赋值
     */
    @Value("#{T(System).currentTimeMillis()}")
    private Long initTime;

    //赋值数值
    @Value("#{2.8E3}")   //科学计数法赋值
    private Double money;

    @Value("#{3.14}")
    private float pi;

    //赋值其他Bean属性值 ,其他Bean属性也必须在初始化时就有值,否则为null
    @Value("#{user.name}")
    private String name;

    //对属性进行其他初始化操作, ?表示是否为空,不为空才会执行API操作
    @Value("#{user.name?.toUpperCase()}")
    private String nameUp;

    public Double getMoney() {
        return money;
    }

    public float getPi() {
        return pi;
    }

    public String getName() {
        return name;
    }

    public Long getInitTime() {
        return initTime;
    }

    public String getNameUp() {
        return nameUp;
    }
}
