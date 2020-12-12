import com.dao.BookMapper;
import com.pojo.Books;
import com.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-05
 * Time: 12:30
 */
public class MyTest {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookMapper = context.getBean("booksMapperImpl", BookService.class);
        for (Books books : bookMapper.selectBooksByLike("%p%")) {
            System.out.println(books);
        }
    }
}
