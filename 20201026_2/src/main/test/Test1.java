import annotationTx.AnnotationIOC;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tx.mapper.StudentMapper;
import tx.model.Student;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-26
 * Time: 17:58
 */
public class Test1 {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationIOC.class);
        StudentMapper studentMapper = context.getBean("getImp", StudentMapper.class);
        for (Student student : studentMapper.selectStudent()) {
            System.out.println(student);
        }

    }
}
