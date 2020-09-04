import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-03
 * Time: 15:04
 */

class People {
    public String name;
    public People brother;
}
public class Test {

    public static void main1(String[] args) {
        People people = new People();
        People people1 = new People();

        people.brother = people1;
        people1.brother = people;

        people = null;
        people1 = null;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(null, 2);
        map.put(null, 4);
        System.out.println(map.get(null));
    }

}
