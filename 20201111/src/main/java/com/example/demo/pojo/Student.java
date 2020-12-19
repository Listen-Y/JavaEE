package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-13
 * Time: 12:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
//下面这俩个注解很重要, 一个表示将这个类托管给spring 一个表示使用yaml实例化这个类
@Component
@ConfigurationProperties(prefix = "student")
@Validated
public class Student {

    @Size(min = 3, max = 5, message = "数字太大了哈哈哈")
    private String name;
    @Max(value = 100)
    private int age;
    private Date birthday;
    private List<String> books;
    private Map<String, Object> maps;
    private boolean healthy;
    private Dog dog;

}
