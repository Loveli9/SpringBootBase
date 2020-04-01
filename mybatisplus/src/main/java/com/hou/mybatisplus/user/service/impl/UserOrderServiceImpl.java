package com.hou.mybatisplus.user.service.impl;

import com.hou.mybatisplus.user.entity.UserOrder;
import com.hou.mybatisplus.user.mapper.UserOrderMapper;
import com.hou.mybatisplus.user.service.IUserOrderService;
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
public class UserOrderServiceImpl extends ServiceImpl<UserOrderMapper, UserOrder> implements IUserOrderService {

}
