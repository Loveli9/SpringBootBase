package com.hou.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * 通过继承WebSecurityConfigurerAdapter获取security默认权限
 * 也可以覆盖其方法实现自定义权限
 */
@Component
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启方法注解可用,设置pre,post注解可用(方法执行之前之后验证)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Qualifier("userDetailsServiceImpl")
    @Autowired
    private UserDetailsService userDetailsService;

    //配置用户签名服务,赋予用户权限等
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //spring5中要求必须使用密码编码器,还可以使用阴钥加密,更加安全
        //Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder("springboot");//使用阴钥加密
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //登陆页面输入用户名和密码时,会根据输入的用户名去数据库里查询对应的密码,进行认证,是否匹配
        auth.userDetailsService(userDetailsService)  //指定userDetailsService实现类去对应方法认证
                .passwordEncoder(passwordEncoder); //指定密码器


        /*//使用内存存储,会占用一定内存,一般开发中使用快速开发
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)//设置密码编码器
                .withUser("user")
                .password(passwordEncoder.encode("houzheng"))//密码一定要加密,否则无法登陆
                //.roles("USER","ADMIN") //赋予角色,使用这种会自动加上ROLE_前缀
                .authorities("ROLE_USER") //赋予角色
                .and() //连接方法,可注册多个用户
                .withUser("yaozhen").password(passwordEncoder.encode("houzheng")).roles("USER");*/
    }

    //配置Filter链
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    //配置拦截保护请求,什么请求放行,什么请求需要验证
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //认证过的用户限制
                //指定路径允许USER或者ADMIN访问
                .antMatchers("/user/test").hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                //指定路径只有ADMIN可以访问
                .antMatchers("/user/admin").hasAuthority("ROLE_ADMIN")
                .anyRequest().permitAll()
                //没有配置权限的其他请求允许匿名访问,即不需要登录
                .and().anonymous() //async
                //使用默认登录页面
                .and().formLogin()
                .and().httpBasic(); //启用http基础验证
    }
}
