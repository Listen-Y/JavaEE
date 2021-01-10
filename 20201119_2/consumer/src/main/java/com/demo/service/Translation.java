package com.demo.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service //使用Spring的Service添加组件
public class Translation {

    @Reference //远程引用指定的服务，他会按照全类名进行匹配，看谁给注册中心注册了这个全类名
    private Translate translate;

    public String getTranslation(String str) {
        return translate.translate(str);
    }

}
