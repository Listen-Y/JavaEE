package com.jdbc.demo.controller;

import com.jdbc.demo.controller.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-15
 * Time: 17:41
 */
@RestController
public class JDBCController {

    //注入jdbcTemplate
    @Autowired
    JdbcTemplate jdbcTemplate;

    //增加user
    @RequestMapping("/add")
    public String add() {
        //只要访问这个路径就执行增加方法
        String sql = "insert into user values(null, ?, ?)";
        String name = "listen";
        String pwd = "121212";
        jdbcTemplate.update(sql, name, pwd);
        return "insert-ok";
    }

    //查询user
    @RequestMapping("/select")
    public List<Map<String, Object>> select() {
        String sql = "select * from user";
        return jdbcTemplate.queryForList(sql);
    }

    //删除user
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id")int id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        return "delete-ok";
    }

    //修改user
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")int id) {
        String sql = "update user set name = ? where id=?";
        String newName = "milk";
        jdbcTemplate.update(sql, newName, id);
        return "update-ok";
    }

}
