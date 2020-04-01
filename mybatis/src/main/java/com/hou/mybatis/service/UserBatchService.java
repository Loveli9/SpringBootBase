package com.hou.mybatis.service;

import com.hou.mybatis.domain.PO.User;

import java.util.List;

public interface UserBatchService {

    int insertBatchUser(List<User> userList);

    int insertUser(User user);
}
