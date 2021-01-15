package com.springcloud;

import com.springcloud.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    UserServiceImpl service;

    @Test
    void contextLoads() {
        System.out.println(service.query(1));
    }

}
