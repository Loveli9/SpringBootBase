package com.hou.mybatis.service.impl;

import com.hou.mybatis.dao.UserDao;
import com.hou.mybatis.domain.PO.User;
import com.hou.mybatis.service.UserBatchService;
import com.hou.mybatis.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserbatchServiceImpl implements UserBatchService {

    @Autowired private UserDao userDao;
    @Autowired private UserService userService;

    @Override    //指定隔离级别(读写提交)
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int insertBatchUser(List<User> userList) {
        //调用方法中有事务的子方法时会使用事物定义的传播行为
        //注: 这里得方法如果是本Service的方法,则传播行为不起作用,因为aop只会拦截一次
        //调用本类方法生效需要添加注解,并使用AopContext获取代理对象再次调用
        userList.forEach(user-> ((UserBatchService)AopContext.currentProxy()).insertUser(user));
        //userList.forEach(user->userService.insertUser(user));
        return userList.size();
    }
    //指定传播行为,开启新事务,别的service事务方法调用此方法时,会执行指定的传播行为
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }
}
