package com.hou.mybatis.dao;

import com.hou.mybatis.domain.PO.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {


    int insertUser(User user);

    List<User> findAllUser();

    int findUserCount();


}
