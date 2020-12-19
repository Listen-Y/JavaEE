package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-13
 * Time: 12:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Dog {

    @Value("大狗")
    private String name;
    @Value("0")
    private int age;

}
