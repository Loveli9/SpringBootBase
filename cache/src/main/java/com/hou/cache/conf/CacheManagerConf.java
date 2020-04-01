package com.hou.cache.conf;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class CacheManagerConf {
    private static List<String> names = Lists.newArrayList("one", "two");
    @Autowired
    private CacheLoader cacheLoader;
    //配置CacheManager
    @Bean(name = "caffeine")
    public CacheManager cacheManagerWithCaffeine() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        Caffeine caffeine = Caffeine.newBuilder()
                //cache的初始容量值
                .initialCapacity(100)
                //maximumSize用来控制cache的最大缓存数量，maximumSize和maximumWeight(最大权重)不可以同时使用，
                .maximumSize(1000)
                //最后一次写入或者访问后过久过期
                .expireAfterAccess(500, TimeUnit.SECONDS)
                //创建或更新之后多久刷新,需要设置cacheLoader
                .refreshAfterWrite(10, TimeUnit.SECONDS);
        cacheManager.setCaffeine(caffeine);
        cacheManager.setCacheLoader(cacheLoader);
        cacheManager.setCacheNames(names);//根据名字可以创建多个cache，但是多个cache使用相同的策略
        cacheManager.setAllowNullValues(false);//是否允许值为空
        return cacheManager;
    }
}