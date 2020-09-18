import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-27
 * Time: 22:04
 */

interface  Person {
    String name = "aaa";
    String getName();
}

public class HashMapDemo implements Person {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "bbb");
        System.out.println(map);
        Person person = new HashMapDemo();
        System.out.println(person.getName());
    }

    @Override
    public String getName() {
        return null;
    }
}
