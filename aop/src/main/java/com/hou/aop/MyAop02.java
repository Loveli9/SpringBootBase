package com.hou.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Aop开发流程:
 * 1 添加依赖
 * 2 写一个切面,使用@Aspect注解,并在相应方法配置通知(前置,后置,环绕等)
 * 3 这个切面类需要加入容器中
 */
@Aspect
@Order(3)
@Component
public class MyAop02 {
    //定义切入点
    @Pointcut("execution(* com.hou.aop.*.*(..))")
    public void pointCut(){}
    /**
     * 前置通知: 使用定义好的切入点方法名表示
     */
    @Before("pointCut()")
    public void log() {
        System.out.println("----切面类3方法之前------日志输出");
    }
    /**
     * JoinPoint可以获取到代理的对象以及参数,
     * args获取方法参数,注:只有有user参数的方法才会走后置通知,因为是 && 
     */
    @After("execution(* com.hou.aop.*.*(..)) && args(user)")
    public void down(JoinPoint point,User user) {
        System.out.println("----切面类3方法之后:获取到参数:"+user.getName() + " || " + point.getTarget().getClass() + point.getArgs());
    }
}
