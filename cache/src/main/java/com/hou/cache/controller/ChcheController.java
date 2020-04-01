package com.hou.cache.controller;

import com.github.benmanes.caffeine.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试静态数据读取cache,即不需要自动加入缓存
 */
@RestController
@RequestMapping("/cache")
public class ChcheController {
    @Autowired
    private LoadingCache loadingCache;
    @GetMapping("/get")
    public Object getValue(String key){
        return loadingCache.get(key);
    }
    @GetMapping("/add")
    public void addValue(String value){
        loadingCache.put(value,value);
    }
    @GetMapping("/delete")
    public void deleteValue(String key){
        loadingCache.invalidate(key);
        loadingCache.invalidateAll();//清楚所有
    }
    @GetMapping("/refresh")
    public void refreshValue(String key){
        //刷新时会根据build方法中中指定的cacheload重新加载
        loadingCache.refresh(key);
    }
}
