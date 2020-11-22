import mybatis.mapper.UserMapper;
import mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-25
 * Time: 14:29
 */
public class Test {

    public static void main1(String[] args) throws IOException {
        String resources = "Mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resources);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper useMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = useMapper.selectUser();
        for (User user : list
             ) {
            System.out.println(user);
        }
    }

    public static void main2(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        System.out.println(userMapper.selectUser());
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserMapper userMapper = context.getBean("userMapper2", UserMapper.class);
        System.out.println(userMapper.selectUser());
    }

}
