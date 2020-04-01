package com.hou.webflux.repository;

import com.hou.webflux.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * webflux中使用JPA需要实现ReactiveMongoRepository接口
 * 会继承许多自动实现的方法
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User,Integer> {

    /**
     * 用户名模糊查询
     */
    Flux<User> findByUserNameLike(String userName);
}
