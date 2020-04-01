package com.hou.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.Jedis;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableCaching  //开启缓存
public class RedisApplication {


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，
     * 并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行,init()方法之前执行
     */
    @PostConstruct
    public void initRedisTemplate(){ //配置redisTemplate序列化
        //将key存储为string序列化,方便跟踪
        RedisSerializer stringSerializer = redisTemplate.getStringSerializer();
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setKeySerializer(stringSerializer);
       /* //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer jacksonSeial = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jacksonSeial.setObjectMapper(om);
        // 值采用json序列化值
        redisTemplate.setValueSerializer(jacksonSeial);
        redisTemplate.setHashValueSerializer(jacksonSeial);*/
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }
}
