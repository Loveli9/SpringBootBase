package com.hou.webflux.config;

import com.hou.webflux.handler.UserHanlder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 *  路由开发,映射请求url和对应处理函数
 */
@Configuration
public class RouterConfig {

    @Autowired
    private UserHanlder userHanlder;

    //springboot会根据类型自动识别出这是一个webflux的路由
    @Bean
    public RouterFunction<ServerResponse> userRouter(){
        return RouterFunctions
                .route(
                        GET("/router/user/{id}")
                        .and(accept(APPLICATION_STREAM_JSON)),//请求信息
                        userHanlder::getUser  //对应处理方法
                )
                .andRoute(
                        POST("/router/user") //路径
                        .and(contentType(APPLICATION_STREAM_JSON)) //参数类型
                        .and(accept(APPLICATION_STREAM_JSON)),  //接受数据类型
                        userHanlder::insertUser)  //对应处理方法
                .andRoute(
                        DELETE("/router/user/{id}")
                        .and(accept(APPLICATION_STREAM_JSON)),
                        userHanlder::deleteUser
                ).andRoute(
                        GET("/router/user/name")
                        .and(accept(APPLICATION_STREAM_JSON)),
                        userHanlder::findUsers
                ).andRoute(
                        PUT("/router/user")
                        .and(accept(APPLICATION_STREAM_JSON))
                        .and(contentType(APPLICATION_STREAM_JSON)),
                        userHanlder::updateUser
                );
    }

}
