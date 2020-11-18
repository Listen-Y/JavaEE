package bike.config;

import bike.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 17:03
 */
@Configuration
@Import(MyConfig.class)
public class MyConfig2 {

    @Bean
    public User User() {
        return new User();
    }
}
