import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 10:08
 */
public class Demo {

    public static void main(String[] args) {

    }
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContex.xml");
        User user = (User)context.getBean("user");
        User user1 = context.getBean("user", User.class);
        System.out.println(user == user1);
        System.out.println(user.toString());
        System.out.println("================");
    }
}
