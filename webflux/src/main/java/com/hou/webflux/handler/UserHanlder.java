package com.hou.webflux.handler;

import com.hou.webflux.pojo.User;
import com.hou.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * 路由函数Handler,处理客户端各个请求
 */
@Service
public class UserHanlder {
    @Autowired
    private UserRepository userRepository;
    //根据id获取用户信息
    public Mono<ServerResponse> getUser(ServerRequest request) {
        //获取请求参数
        Integer id = Integer.valueOf(request.pathVariable("id"));
        //响应数据 ok表示响应成功
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userRepository.findById(id), User.class);//返回内容
    }
    //插入用户
    public Mono<ServerResponse> insertUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                //cache很重要,将对象流缓存起来,否则程序就会一直等待不会继续执行
                //使用flatMap将流中的数据保存,传递的是对象时需要这一步,因为是响应式
                .body(userMono.cache().flatMap(user->userRepository.save(user)),User.class);
    }
    //更新,和保存使用一样
    public Mono<ServerResponse> updateUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userMono.cache().flatMap(user->userRepository.save(user)),User.class);
    }
    //删除用户
    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        //获取请求参数
        Integer id = Integer.valueOf(request.pathVariable("id"));
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userRepository.deleteById(id), Void.class);
    }
    //根据用户名查询用户
    public Mono<ServerResponse> findUsers(ServerRequest request) {
        //获取请求参数
        Optional<String> userName = request.queryParam("userName");
        return ok().contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(userRepository.findByUserNameLike(userName.get()),User.class);
    }
}
