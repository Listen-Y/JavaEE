import annotationProxy.AllAnnotation;
import myProxy.Database;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-24
 * Time: 14:34
 */
public class Test2 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AllAnnotation.class);
        Database database = context.getBean("dao", Database.class);
        database.add();
    }
}
