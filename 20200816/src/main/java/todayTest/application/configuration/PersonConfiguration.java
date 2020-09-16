package todayTest.application.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import todayTest.application.interceptor.LoginIInterceptor;
import todayTest.application.modle.Person;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-17
 * Time: 10:19
 */
@Configuration
//用于启动时完成的配置工作
public class PersonConfiguration implements WebMvcConfigurer {

    //实现WebMvcConfigurer实现拦截器
    //重写addInterpetor方法
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //实现用户会话管理的功能
        //在这里进行路径拦截选择
        //下面的设置表示我拦截以/per/开头的所有路径, 但是除了/per/test14我是不会拦截的
        //如果拦截到我就去执行addInterceptor中LoginInterceptor的方法
        registry.addInterceptor(new LoginIInterceptor()).addPathPatterns("/per/**").excludePathPatterns("/per/test14");
    }

    @Bean
    //注意的方法名和返回名不一样 但是这个bean对象是以方法名作为他的名称的

    public Map<String, String> test1() {
        Map<String, String> map = new HashMap<>();
        map.put("勒布朗", "詹姆斯");
        map.put("科比", "布莱恩特");
        return map;
    }

    @Bean
    public Person person1() {
        Person person = new Person();
        person.setName("Listen");
        person.setId("612720199900008000");
        person.setAge(20);
        return person;
    }

    @Bean
    public Person person2() {
        Person person = new Person();
        person.setName("Frank");
        person.setId("892720199900008000");
        person.setAge(22);
        return person;
    }

}
