import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("abc");
        list.add("abcde");
        Collections.sort(list);
        System.out.println(list);
    }

}
