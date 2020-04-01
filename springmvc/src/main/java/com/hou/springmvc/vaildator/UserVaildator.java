package com.hou.springmvc.vaildator;

import com.hou.springmvc.pojo.MyUser;
import com.hou.springmvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * 自定义user对象验证
 * Validator: spring的验证接口
 */
@Component
public class UserVaildator implements Validator {
    //如果是需要验证的类型,则返回true,继续验证
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(MyUser.class);
    }
    //自定义验证逻辑
    @Override
    public void validate(Object o, Errors errors) {
        System.out.println("进行自定义数据验证");
        if(o==null){
            //直接返回错误信息,不进入controller方法
            errors.rejectValue("",null,"参数不能为空");
            return;
        }
        MyUser myuser= (MyUser) o;
        if(StringUtils.isEmpty(myuser.getId())) errors.rejectValue("id",null,"id不能为空");
        if(StringUtils.isEmpty(myuser.getName())) errors.rejectValue("id",null,"姓名不能为空");
        //其他参数验证,最后结果统一放入errors,进入controller
    }
}
