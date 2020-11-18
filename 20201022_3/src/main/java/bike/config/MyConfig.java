package bike.config;

import bike.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 16:38
 */
//表示这个类是java的一个配置类
@Configuration
@ComponentScan("bike.model")
public class MyConfig {

    //表示返回值是一个bean对象
    @Bean
    public User getUser() {
        return new User();
    }
}
