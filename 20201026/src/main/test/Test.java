import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import transaction.mapper.StudentMapper;
import transaction.mapper.UserMapper;
import transaction.model.Student;
import transaction.model.User;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 11:14
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);

        User user = new User(1, "Bikee", "陕西省未央区");
        System.out.println(userMapper.addUser(user));

        for (User u : userMapper.selectUser()) {
            System.out.println(u);
        }
    }

    public static void main2(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        StudentMapper studentMapper = context.getBean("studentMapper", StudentMapper.class);
        studentMapper.insert(new Student(2, "listen", "basketball"));
        studentMapper.insert(new Student(5, "bike", "pingPong"));
        studentMapper.insert(new Student(9, "flake", "swim"));
        for (Student student : studentMapper.selectStudent()) {
            System.out.println(student);
        }
        studentMapper.delete(2);
        for (Student student : studentMapper.selectStudent()) {
            System.out.println(student);
        }
    }
}
