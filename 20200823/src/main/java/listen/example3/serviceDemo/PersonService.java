package listen.example3.serviceDemo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-23
 * Time: 15:36
 */
@Service
public class PersonService {

    //这里我们首先自定义一个类和对想, 将这个对象保存在缓存中
    static class Person{
        public String name;
        public int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    private static Person person = new Person("listen", 21);

    //缓存的查询 并将查到的数据保存至缓存中
    @Cacheable(cacheNames = "person", key = "#id")
    public Object getPersonById(int id) throws InterruptedException {
        //我通过id查询我的person 如果此时缓存中没有这个id对应的person就会进行查询
        System.out.println("进入查询...");
        //方便我们演示如果进入查询我们多等待3秒
        TimeUnit.SECONDS.sleep(3);
        if (id == 1) {
            return person;
        }
        return "Id错误...";
    }

    //修改这个id绑定的对象的属性
    @CachePut(cacheNames = "person", key = "#id")
    public Object updatePerson(int id, String newName) {
        System.out.println("进入修改方法...");
        if (id == 1) {
            person.name = newName;
            return person;
        }
        return "Id错误...";
    }

    //删除缓存
    @CacheEvict(cacheNames = "person", key = "#id")
    public boolean delPerson(int id) {
        return id == 1;
    }
}
