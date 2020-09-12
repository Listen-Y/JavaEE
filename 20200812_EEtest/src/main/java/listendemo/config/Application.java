package listendemo.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import listendemo.config.intercceptor.LoginInterceptor;
import listendemo.modle.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-12
 * Time: 21:20
 */
@Configuration
public class Application  {
    //这个接口是用来web框架执行初始化工作的时候执行的

// implements WebMvcConfigurer


    //这个方法是被default修饰的 所以实现这个接口的时候不是必须要重写这个方法
    //@Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注意在这里静态资源(而且还是模糊匹配拦截比如/* 和 /**)也会被拦截到

         //链式方法调用 当前类型  返回值就是this
        // 后面这个方法表示匹配/user/**这个路径, 去除/user/login路径
        registry.addInterceptor(new LoginInterceptor(new ObjectMapper()))
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/login");
    }

    @Bean
    public Map<Integer, Integer> test() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 100);
        map.put(2, 200);
        return map;
    }

    @Bean
    public User user1() {
        User user = new User();
        user.setUsername("詹姆斯");
        user.setPassword("123");
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setUsername("勒布朗");
        user.setPassword("345");
        return user;
    }

}
