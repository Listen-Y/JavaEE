/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-07-23
 * Time: 10:31
 */
import java.util.*;
import java.io.*;
public class Main1{
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s ="";
        Map<String,Integer> map = new LinkedHashMap<String,Integer>();
        while ((s = reader.readLine()) != null){
            String[] s1 = s.split(" ");
            String name1 = s1[0];
            String hang = s1[1];
            String name = name1.substring(name1.lastIndexOf("\\") + 1);
            if(name.length() > 16){
                name = name.substring(name.length() - 16);
            }
            String err = name+" "+hang;
            if (map.containsKey(err)){
                map.put(err,map.get(err)+1);
            } else {
                map.put(err,1);
            }
        }
        int count = 0;
        for (String key:map.keySet()){
            count++;
            if(count > (map.size() -8))
                System.out.println(key + " " + map.get(key));
        }

    }
}
