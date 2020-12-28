package com.mybatis.demo.dao;

import com.mybatis.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-16
 * Time: 20:54
 */
@Mapper
@Repository
public interface UserMapper {

    List<User> select();

    User query(@Param("id") int id);

    int add(User user);

    int delete(@Param("id") int id);
}
