import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.pojo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 17:15
 */
public class Test {

    //Java对象 转 JSON字符串
    @org.junit.Test
    public void test() {
        User user = new User("程序猿", 22, "LOL");
        String jsonStr = JSON.toJSONString(user);
        System.out.println(jsonStr);
    }

    //Java数组 转 JSON字符串
    @org.junit.Test
    public void test1() {
        //创建一个对象
        User user1 = new User("程序猿1号", 21, "LOL");
        User user2 = new User("程序猿2号", 2, "LOL");
        User user3 = new User("程序猿3号", 22, "LOL");
        User user4 = new User("程序猿4号", 23, "LOL");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        String jsonStr = JSON.toJSONString(list);
        System.out.println(jsonStr);
    }


    //JSON字符串 转 Java对象
    @org.junit.Test
    public void test2() throws JsonProcessingException {
        //使用ObjectMapper构建json字符串, 然后用JSON转成java对象
        User user = new User("程序猿", 22, "LOL");
        String jsonStr = new ObjectMapper().writeValueAsString(user);
        System.out.println(jsonStr);

        User user1 = JSON.parseObject(jsonStr, User.class);
        System.out.println(user1);
    }


    //Json数组字符串 转 java数组
    @org.junit.Test
    public void test3() {
        //创建一个对象
        User user1 = new User("程序猿1号", 21, "LOL");
        User user2 = new User("程序猿2号", 2, "LOL");
        User user3 = new User("程序猿3号", 22, "LOL");
        User user4 = new User("程序猿4号", 23, "LOL");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        String jsonStrArray = JSON.toJSONString(list);

        List<User> users = JSON.parseArray(jsonStrArray, User.class);
        System.out.println(users);
    }


    @org.junit.Test
    public void test4() throws IOException {
        User[] users = new User[3];
        users[0] = new User("程序猿1号", 21, "LOL");
        users[1] = new User("程序猿1号", 21, "LOL");
        users[2] = new User("程序猿1号", 21, "LOL");
        ObjectMapper objectMapper = new ObjectMapper();
        String text = objectMapper.writeValueAsString(users);

        User[] users1 = objectMapper.readValue(text, User[].class);
        System.out.println(Arrays.toString(users1));
    }
}
