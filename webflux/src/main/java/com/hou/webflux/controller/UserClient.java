package com.hou.webflux.controller;

import com.hou.webflux.pojo.User;
import com.hou.webflux.pojo.UserVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Iterator;

@RestController
@RequestMapping("/client")
public class UserClient {

    @GetMapping("/test")
    public void testWebClient(){
        WebClient webClient = WebClient.create("http://localhost:8080");
        User user = new User(1, "侯征", 23);
        User user01 = new User(2, "侯征", 23);
        insertUser(webClient,user);
        insertUser(webClient,user01);
        deleteUser(webClient,1);
        getUser(webClient,2);
        findUserByUserName(webClient,"侯");
    }

    private void insertUser(WebClient webClient, User user) {
        Mono<User> userMono = webClient
                .post().uri("/user") //接口路径
                .contentType(MediaType.APPLICATION_STREAM_JSON) //请求数据类型
                .body(Mono.just(user), User.class) //传递参数
                .accept(MediaType.APPLICATION_STREAM_JSON) //接受的返回类型
                .retrieve()   //设置结果检测规则,设置后才可以进行返回结果转换
                .bodyToMono(User.class); //将返回结果转换为Mono流
        //获取数据,此时才会发送请求
        User user1 = userMono.block();
        System.out.println(user1);
    }

    private void deleteUser(WebClient webClient, int id) {
        Mono<Void> voidMono = webClient.delete().uri("/user/{id}", id)
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .retrieve()
                .bodyToMono(Void.class);
        Void block = voidMono.block();
        System.out.println(block);
    }

    private void getUser(WebClient webClient, int id) {
        Mono<User> userMono = webClient
                .get().uri("/user/{id}", id) //get请求路径参数
                .accept(MediaType.APPLICATION_STREAM_JSON) //接受返回类型为JSON数据流
                .retrieve()
                //处理服务端错误,第一个lamdba返回一个boolean,如果为true则执行第二个lamdba,直接返回一个空的流
                .onStatus(
                        status->status.is4xxClientError() || status.is5xxServerError(),
                        response->Mono.empty())
                .bodyToMono(User.class);
        User user = userMono.block();
        if(user!=null) System.out.println(user);
    }

    private void getUserByEX(WebClient webClient, int id) {
        Mono<UserVO> userMono = webClient
                .get().uri("/user/{id}", id) //get请求路径参数
                .accept(MediaType.APPLICATION_STREAM_JSON) //接受返回类型为JSON数据流
                .exchange() //启用数据交换
                .doOnError(ex->Mono.empty()) //服务端出现错误返回空Mono
                .flatMap(reponse->reponse.bodyToMono(User.class)) //将服务端返回的数据流转成User
                //将user转成我们需要的UserVo
                .map(x-> new UserVO(x.getId(),x.getUserName(),x.getAge()));
        UserVO user = userMono.block();
        if(user!=null) System.out.println(user);
    }


    private void findUserByUserName(WebClient webClient, String userName) {
        Flux<User> userFlux = webClient
                .get().uri("/user/name", userName) //get请求路径参数
                .accept(MediaType.APPLICATION_STREAM_JSON) //接受返回类型为JSON数据流
                .retrieve()
                .bodyToFlux(User.class);
        //获取迭代器,执行时,服务器才会响应
        Iterator<User> iterator = userFlux.toIterable().iterator();
        while(iterator.hasNext()){
            //Flux: 响应式返回,每循环一次返回一个数据,直到所有数据返回完
            System.out.println(iterator.next());
        }
    }

}
