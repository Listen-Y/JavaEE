package com.duck.service;

import com.duck.pojo.Duck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 12:33
 */
public interface DuckService {

    List<Duck> select();
    int insert(Duck duck);
    int update(Duck duck);
    int delete(String id);
    List<Duck> selectByLike(String keyWords);
    List<Duck> selectByRange(Map<String, Object> map);
    Duck selectOne(String id);
}
