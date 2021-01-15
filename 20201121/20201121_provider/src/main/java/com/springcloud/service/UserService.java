package com.springcloud.service;

import com.springcloud.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 14:42
 */
public interface UserService {

    List<User> selectAll();
    User query(int id);
    boolean add(User user);
    boolean delete(int id);
}
