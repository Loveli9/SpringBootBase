package com.hou.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * spring提供UserDetailsService接口用来获取UserDetails对象
 * 进行用户认证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //通过用户名获取用户信息UserDetails,包括密码,是否可用,角色数组等
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //从数据库获取用户信息
        System.out.println("查询用户信息"+userName);
        //此处测试模拟
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        //authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //此处必须返回指定密码器加密后的密码
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode(userName);//加密之后的密码,此处采用用户名加密,即只有密码和用户名相同才能通过认证
        System.out.println(encode);
        UserDetails userDetails = new User(userName,encode,authList);
        System.out.println(userDetails.getAuthorities().toString());
        return userDetails;
    }
}
