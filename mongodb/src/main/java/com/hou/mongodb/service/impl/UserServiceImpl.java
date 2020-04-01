package com.hou.mongodb.service.impl;

import com.hou.mongodb.pojo.User;
import com.hou.mongodb.service.UserService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    //删除
    public DeleteResult deleteUser(Integer id) {
        Criteria criteria = Criteria.where("id").is(id);
        return mongoTemplate.remove(Query.query(criteria),User.class);
    }

    public UpdateResult updateUser(Integer id, String userName) {
        //先确定要更新的对象
        Criteria criteria = Criteria.where("id").is(id);
        //定义更新对象
        Update update = Update.update("userName", userName);
        //update.set("",""); 可继续设置更新其他字段
        //updateFirst: 只更新第一个 updateMulit: 更新匹配到的多个
        return mongoTemplate.updateFirst(Query.query(criteria),update,User.class);
    }

    public User getUserById(Integer id) {
        return mongoTemplate.findById(id,User.class);
        /**
         * 只查询一个
         * Criteria criteria = Criteria.where("id").is(id);
         * mongoTemplate.findOne(Query.query(criteria),User.class);
         */
    }

    public List<User> getUsers(String userName, Integer skip, Integer limit) {
        //查询准则
        Criteria criteria = Criteria.where("userName").regex(userName); //模糊匹配
        //构建查询条件, 最多返回多少条记录  以及跳过多少条记录
        Query query = Query.query(criteria).limit(limit).skip(skip);
        return mongoTemplate.find(query,User.class);
    }

    public void insertUser(User user) {
        //如果文档id存在就更新,否则添加
        mongoTemplate.save(user,"user");//存储的表名
    }
}
