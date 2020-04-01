package com.hou.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.hou.mybatis.domain.PO.User;
import com.hou.mybatis.domain.VO.PageBean;

import java.util.List;

public interface UserService {

    PageInfo findAllUserByPage(int currentPage, int pageSize);

    User insertUser(User user);

    User selectUserById(String id);

    User updateUser(User user);

    int deleteUserById(String id);
}

