package com.hou.webflux.service.impl;

import com.hou.webflux.pojo.User;
import com.hou.webflux.repository.UserRepository;
import com.hou.webflux.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Mono<User> getUser(Integer id) {
        return userRepository.findById(id);
    }
    @Override
    public Mono<User> insertUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public Mono<User> updateUser(User user) {
        return userRepository.save(user);//存在即更新
    }
    @Override
    public Mono<Void> deleteUser(Integer id) {
        return userRepository.deleteById(id);
    }
    @Override
    public Flux<User> findUsers(String userName) {
        return userRepository.findByUserNameLike(userName);
    }
}
