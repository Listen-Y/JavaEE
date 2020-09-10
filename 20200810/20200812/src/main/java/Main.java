
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



    }
}