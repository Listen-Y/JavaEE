package com.cache8.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component //表示将这个类托付于Spring管理
public class PersonService {

    //如果是第一次访问这个数据 就将这个数据添加到缓存中
    @Cacheable(cacheNames = "person", key = "#id")
    public String getPerson(int id) {
        System.out.println("添加缓存...");
        return "获得的person为:" + id;
    }

}
