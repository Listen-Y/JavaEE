package com.springcloud.dao;

import com.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-21
 * Time: 14:40
 */
@Mapper
@Repository
public interface UserDao {

    List<User> selectAll();
    User query(@Param("id") int id);
    boolean add(User user);
    boolean delete(@Param("id") int id);
}
