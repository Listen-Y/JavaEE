package com.demo.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Service  //使用Dubbo的Service注解,告诉Dubbo这是一个服务
@Component //使用component告诉SpringBoot这是一个组件, 不使用@Service是因为zookeeper避免和zookeeper混淆
public class TranslateImpl implements Translate {
    @Override
    public String translate(String str) {
        if (str == null) return null;

        if ("pig".equalsIgnoreCase(str)) return "猪";
        if ("dog".equalsIgnoreCase(str)) return "狗";
        return "找不到";
    }
}
