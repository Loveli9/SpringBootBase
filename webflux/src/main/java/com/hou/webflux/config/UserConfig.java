package com.hou.webflux.config;

import com.hou.webflux.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * 配置转换器,将前端约定的参数格式转换为User
 *  可实现WebFluxConfigurer接口对组件进行自定义配置
 */
@Configuration
public class UserConfig implements WebFluxConfigurer {

    //可通过注册转换器实现
    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new 转换器);
    }*/
    //也可直接将转换器配置成一个Bean,springBoot会自动识别为类型转换器
    @Bean
    public Converter<String, User> stringToUserConverter(){
        /*
         * 覆写Converter接口方法,实现自定义转换
         *  将参数: 2-侯征-24 转换为user对象
         */
        return str->{
            String[] split = str.split("-");
            return new User(Integer.valueOf(split[0]),split[1],Integer.valueOf(split[2]));};
    }

    //注册验证器
    @Override
    public Validator getValidator() {
        return new UserValidator();
    }
}
