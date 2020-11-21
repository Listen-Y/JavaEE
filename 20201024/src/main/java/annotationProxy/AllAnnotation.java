package annotationProxy;

import myProxy.Dao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-24
 * Time: 14:30
 */
@Configuration
public class AllAnnotation {

    @Bean
    public Object log() {
        return new Log();
    }

    @Bean
    public Object dao() {
        return new Dao();
    }
}
