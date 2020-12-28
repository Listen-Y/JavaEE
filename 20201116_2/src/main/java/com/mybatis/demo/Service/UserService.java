package com.mybatis.demo.Service;

import com.mybatis.demo.dao.UserMapper;
import com.mybatis.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-16
 * Time: 20:56
 */
@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> select() {
        return userMapper.select();
    }

    @Override
    public User query(int id) {
        return userMapper.query(id);
    }

    @Override
    public int add(User user) {
        return userMapper.add(user);
    }

    @Override
    public int delete(int id) {
        return userMapper.delete(id);
    }
}
