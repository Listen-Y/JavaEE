import model.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-22
 * Time: 10:52
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        /*People people = context.getBean("people", People.class);
        people.getCat().shot();
        people.getDog().shot();
        System.out.println(people.getName());
        System.out.println("==================");
        //使用AutoWired的byName自动装配
        People people1 = context.getBean("people1", People.class);
        people1.getCat().shot();
        people1.getDog().shot();
        System.out.println(people1.getName());
        System.out.println("==================");
        //使用AutoWired的byType自动装配
        People people2 = context.getBean("people2", People.class);
        people2.getCat().shot();
        people2.getDog().shot();
        System.out.println(people2.getName());
        System.out.println("==================");
        //使用@AutoWired注解
        People people3 = context.getBean("people3", People.class);
        people3.getCat().shot();
        people3.getDog().shot();
        System.out.println(people3.getName());
        System.out.println("==================");
        //为空演示*/
        People people4 = context.getBean("people4", People.class);
        people4.getCat().shot();
        people4.getDog().shot();
        System.out.println(people4.getName());
        System.out.println("==================");
    }
}
