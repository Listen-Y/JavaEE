import Listen.Duk;
import Listen.Person;
import Listen.School;
import Listen.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //加载配置文件
        //Spring开启容器的方式就是应用上下文(可以配置管理bean对象 及其他工作)
        //根据classpath路径 指定一个配置文件
        //根据配置文件完成配置工作(如bean的实例化)
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        //通过bean的名称获取bean对象
        String love =  (String)context.getBean("love");
        System.out.println(love);

        //通过类型获得bean对象 如果该类型有多个对象 就会报错  只支持一个该类型的对象 返回的是一个泛型对象可以忽略强转
        String love1 =  context.getBean(String.class);
        System.out.println(love1);
        System.out.println("====测试自定义类====");

        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Person person2 = (Person)context.getBean("person2");
        System.out.println(person2);

        Person person3 = (Person)context.getBean("person3");
        System.out.println(person3);

        Teacher teacher1 = (Teacher)context.getBean("teacher1");
        System.out.println(teacher1);

        Teacher teacher2 = (Teacher)context.getBean("teacher2");
        System.out.println(teacher2);

        Teacher teacher3 = (Teacher)context.getBean("teacher3");
        System.out.println(teacher3);

        School school = (School)context.getBean("school");
        System.out.println(school);

        Duk duk = (Duk)context.getBean("duck1");
        System.out.println(duk);
    }
}