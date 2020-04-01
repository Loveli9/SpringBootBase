package com.hou.springmvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//自定义拦截器
@Component
public class MyHandIerInterceptor implements HandlerInterceptor {

    //处理器前执行,返回true,才会继续执行处理器逻辑
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,Object handler) throws Exception {
        System.out.println("controller之前");
        return true;
    }
    //处理器之后执行
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("controller之后");
    }
    //处理器完成执行
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("controller完成");
    }
}
