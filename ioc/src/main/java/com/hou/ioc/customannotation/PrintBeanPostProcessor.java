package com.hou.ioc.customannotation;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//实现每一个Bean初始化的时候,以list中开头的类的名字,打印出自己的名字
public class PrintBeanPostProcessor implements BeanPostProcessor {
    private List<String> packages;

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //遍历Bean注入容器中时,注入的包名数组packages
        for (String string : packages) {
            //如果类的全路径是以包名开头的,即是注定包下的类
            if (bean.getClass().getName().startsWith(string)) {
                System.out.println("-----" + bean.getClass().getName());
            }
        }
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String arg1) throws BeansException {
        return bean;
    }

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }


}
