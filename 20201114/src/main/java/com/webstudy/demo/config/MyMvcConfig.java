package com.webstudy.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-14
 * Time: 16:53
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //实现访问路径转发 只要访问h2这个路径就跳转到test2这个页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/h2").setViewName("test2");
    }

    //以bean的形式返回自己实现的组件
    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver {


        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
