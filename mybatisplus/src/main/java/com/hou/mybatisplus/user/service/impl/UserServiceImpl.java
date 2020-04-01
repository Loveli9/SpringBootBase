package com.hou.mybatisplus.user.service.impl;

import com.hou.mybatisplus.user.entity.User;
import com.hou.mybatisplus.user.mapper.UserMapper;
import com.hou.mybatisplus.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 侯征
 * @since 2019-07-11
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
