package com.example.demo.config;

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
 * Date: 2020-11-15
 * Time: 12:41
 */
@Configuration
public class MyMvcConfiguration implements WebMvcConfigurer {


    //实现拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("[DEBUG_INTERCEPTOR]===>");
        //添加自定义拦截器, 匹配/**表示所有请求, 但是除了后面那些"/login", "/index.html", "/", "/css/**", "/js/**", "/img/**"
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/index.html", "/", "/css/**", "/js/**", "/img/**");
    }

    //实现路径转发, 只要访问index.html这个路径就过度到templates路径下的index.html
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("[DEBUG_VIEW]===>");
        registry.addViewController("/index.html").setViewName("index");
    }

    //实现额外组件生成, 生成一个额外的视图解析器, 并以bean的形式返回到spring中
    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
