package com.demo;

import com.demo.service.Translation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Translation translation;

    @Test
    void contextLoads() {
        System.out.println(translation.getTranslation("pig"));
    }

}
