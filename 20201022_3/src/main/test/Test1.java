import bike.config.MyConfig;
import bike.config.MyConfig2;
import bike.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 16:39
 */
public class Test1 {

    public static void main(String[] args) {
        //使用AnnotationConfigApplicationContext去扫描我们添加@Configuration注解的类
        // 去获取这个类中所有被@Bean修饰的字段, 表示返回的是一个bean对象
        ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig2.class);
        User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());
        System.out.println("=================");
        User user1 = context.getBean("User", User.class);
        System.out.println(user1.getName());
    }
}
