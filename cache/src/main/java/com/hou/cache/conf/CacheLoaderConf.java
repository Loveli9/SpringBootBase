package com.hou.cache.conf;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheLoaderConf {
    /**
     * 必须要指定这个Bean，refreshAfterWrite配置属性才生效
     */
    @Bean
    public CacheLoader<Object, Object> cacheLoader() {
        return new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) throws Exception { return null;}
            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                System.out.println("--refresh--:"+key);
                return oldValue;
            }
        };
    }
}
