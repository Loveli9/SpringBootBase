package com.hou.webflux.config;

import com.hou.webflux.pojo.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *  注册验证器,Controller使用@valid注解时会触发
 *
 */
public class UserValidator implements Validator {

    //支持验证的类型
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        //验证逻辑,ex:用户名不能为空
    }
}
