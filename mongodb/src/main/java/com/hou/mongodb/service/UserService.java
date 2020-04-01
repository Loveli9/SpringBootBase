package com.hou.mongodb.service;

import com.hou.mongodb.pojo.User;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import java.util.List;

public interface UserService {

    DeleteResult deleteUser(Integer id);

    UpdateResult updateUser(Integer id, String userName);

    User getUserById(Integer id);

    void insertUser(User user);

    List<User> getUsers(String userName, Integer skip, Integer limit);
}
