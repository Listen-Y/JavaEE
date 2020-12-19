package com.example.demo;

import com.example.demo.pojo.Dog;
import com.example.demo.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    Dog dog;

    @Autowired
    Student student;

    @Test
    void contextLoads() {
        System.out.println(dog);
        System.out.println(student);
    }
}
