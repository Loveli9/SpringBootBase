package com.hou.webflux.service;

import com.hou.webflux.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUser(Integer id);

    Mono<User> insertUser(User user);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(Integer id);

    Flux<User> findUsers(String userName);
}
