package com.restful.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restful.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-04
 * Time: 16:43
 */
@RestController
public class UserController {


    @RequestMapping(value = "u1", produces = "application/json;charset=utf-8")
    public String u1() throws JsonProcessingException {
        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User("程序猿", 3, "game");
        //将我们的对象解析成为json格式
        //由于@RestController注解，这里会将str转成json格式返回；十分方便
        return mapper.writeValueAsString(user);
    }

    @RequestMapping("/u2")
    public String u2() throws JsonProcessingException {

        //创建一个jackson的对象映射器，用来解析数据
        ObjectMapper mapper = new ObjectMapper();
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

        //将我们的对象解析成为json格式
        return mapper.writeValueAsString(list);
    }

    @RequestMapping("/u3")
    public String u3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(format);
        return mapper.writeValueAsString(date);
    }
}
