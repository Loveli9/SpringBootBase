package com.hou.springmvc.controller;

import com.hou.springmvc.pojo.MyUser;
import com.hou.springmvc.pojo.User;
import com.hou.springmvc.vaildator.UserVaildator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserVaildator userVaildator;

    /**
     * 数据验证
     *  @Valid: 表示需要开启验证这个实体
     * @param user
     * @param errors 错误信息,由springMVC验证之后自动填充
     * @return
     */
    @GetMapping("/vaild")
    public Map<String,Object> vaildUser(@Valid @RequestBody User user, Errors errors){
        Map<String,Object> result=new HashMap<>();
        //获取验证结果
        errors.getAllErrors().stream().forEach(x->{
            String key=null;
            if(x instanceof FieldError){ //字段错误
                FieldError fe= (FieldError) x;
                key=fe.getField();
            }else{  //非字段错误
                key=x.getObjectName();
                String defaultMessage = x.getDefaultMessage();
            }
            result.put(key,x.getDefaultMessage());
        });
        return result;
    }

    /**
     * @InitBinder的方法会在controller方法执行之前执行
     *   注册自定义的user验证器,当有实体需要验证时,springmvc会遍历所有的验证器
     *   找到自定义注册的这个进行验证
     * @param webDataBinder
     */
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.setValidator(userVaildator);//绑定验证器
    }

    @GetMapping("/vaildMyUser")
    public Map<String,Object> vaildMyUser(@Valid @RequestBody MyUser myuser, Errors errors){
        Map<String,Object> result=new HashMap<>();
        if(errors.hasErrors()){ //如果有错误
            //获取验证结果
            errors.getAllErrors().stream().forEach(x->{
                String key=null;
                if(x instanceof FieldError){ //字段错误
                    FieldError fe= (FieldError) x;
                    key=fe.getField();
                }else{  //对象错误
                    key=x.getObjectName();
                    String defaultMessage = x.getDefaultMessage();
                }
                result.put(key,x.getDefaultMessage());
            });
        }else{
            System.out.println("验证通过,继续执行业务逻辑");
            result.put("0","成功");
        }
        return result;
    }

}
