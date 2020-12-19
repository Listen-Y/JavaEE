package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//通过这个注解, 标注这个类是一个SpringBoot的应用
@SpringBootApplication
/**
 * 在这个注解里有三个较为重要的注解,一个是用来组件扫描
 * 还有一个是SpringBoot的配置注解
 * 我们进去这个注解看到这里就是一些spring的组件
 * 最为关键的就是那个@EnableAutoConfiguration, 在这个注解里面有一个inport, 里面是自动配置选择器AutoConfigurationImportSelector
 * 在这个选择器中有一个获取自动配置的入口方法, 这个方法里有一个通过名字去加载的自动配置文件的接口, 我们进入这个接口会发现内部使用了很多
 * META-INF/spring.factories这个路径下的文件
 *我们通过查找在spring-boot-autoconfiguation这个jar包下确实有, 而且里面都是些自动配置文件的接口
 * 我们进入webmvcautoconfigguation, 首先看到这是使用javaconfig实现的一个注解类, 在这个注解类中很多重要的配置组件都是使用@Bean
 * 将其返回到spring的ioc容器中, 但是每个注解了的开头还有有一些import, 我开发一些我没有导入启动器对应的自动装配类中, 发现他们是使用不成了,
 * 因为没有说找不到对应的类, 所有我觉得springboot把很多模块分为启动器的形式导入, 当项目启动时, 虽然会扫描到所有的自动配置, 但是并不会所有的
 *配置类都会生效, 只要导入对应的启动器的自动配置才会生效
 */
public class DemoApplication {

    public static void main(String[] args) {
        //启动SpringBoot
        SpringApplication.run(DemoApplication.class, args);
    }

}
