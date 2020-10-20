import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 14:13
 */
class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class JsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().create();
        String jsonStr = gson.toJson(new Person("listen", 20));
        System.out.println(jsonStr);
        Person person = gson.fromJson("{\"name\":\"listen\",\"age\":20}\n", Person.class);
        System.out.println(person);
    }
}
