package com.hou.springmvc.advice;

import com.hou.springmvc.vaildator.UserVaildator;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.text.SimpleDateFormat;

//指定包下使用指定注解的类增加统一增强操作
@ControllerAdvice(basePackages = "com.hou.*",annotations = Controller.class)
public class MyControllerAdvice {

    //绑定格式化,参数转换器等
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        //自定义日期格式,不允许为空
        new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),false);
        webDataBinder.setValidator(new UserVaildator());//绑定验证器
    }
    //controller之前执行,初始化数据操作,例如给每个参数都加openid等,controller可以直接获取
    @ModelAttribute
    public void modelAttribute(Model model){
        model.addAttribute("logo","侯征");
    }
    //异常处理,指定所有拦截的方法异常时跳转到指定页面或者返回异常信息
    @ExceptionHandler
    public String exception(Model model,Exception ex) {
        model.addAttribute("msg",ex.getMessage());
        return "error";
    }

}
