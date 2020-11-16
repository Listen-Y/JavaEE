import hello.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * 体会IOc控制反转
 * User: Listen-Y.
 * Date: 2020-10-21
 * Time: 20:05
 */
public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());

        Hello h1 = (Hello) context.getBean("h1");
        System.out.println(h1.toString());
    }
}
