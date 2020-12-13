package com.duck.dao;

import com.duck.pojo.Duck;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 11:22
 */
public interface DuckMapper {

    List<Duck> select();
    int insert(Duck duck);
    int update(Duck duck);
    int delete(@Param("id") String id);
    List<Duck> selectByLike(String keyWords);
    List<Duck> selectByRange(Map<String, Object> map);
    Duck selectOne(@Param("id") String id);
}
