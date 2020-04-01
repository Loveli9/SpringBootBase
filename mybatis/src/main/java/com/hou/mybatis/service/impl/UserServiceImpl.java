package com.hou.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hou.mybatis.dao.UserDao;
import com.hou.mybatis.domain.PO.User;
import com.hou.mybatis.domain.VO.PageBean;
import com.hou.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    //指定读写提交隔离级别,超时时间1秒
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public PageInfo findAllUserByPage(int currentPage,int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<User> userList = userDao.findAllUser();
        //使用插件的PageInfo
        PageInfo<User> result=new PageInfo(userList);
        // int totalNum = userDao.findUserCount();
        // PageBean pageBean = new PageBean(currentPage, pageSize, totalNum);
        //pageBean.setItems(userList);
        return result;
    }

    //指定传播行为,开启新事务,别的service事务方法调用此方法时,会执行指定的传播行为
    @Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    @Cacheable(value = "redisCache",key="'redis_user_'+#result") //使用key将方法结果缓存
    public User insertUser(User user) {
        userDao.insertUser(user);
        return user;
    }
    //查询单个用户
    @Override
    @CachePut(value = "redisCache",key="'redis_user_'+#id")
    public User selectUserById(String id) {
        return null;
    }
    //更新用户   重新缓存,即更新缓存
    @Override
    @CachePut(value = "redisCache",key="'redis_user_'+#result.id")
    public User updateUser(User user) {
        return null;
    }
    //删除用户
    @Override   //移除缓存
    @CacheEvict(value = "redisCache",key="'redis_user_'+#id",beforeInvocation = false)
    public int deleteUserById(String id) {
        return 0;
    }

}
