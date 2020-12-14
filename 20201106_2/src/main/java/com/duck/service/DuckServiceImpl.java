package com.duck.service;

import com.duck.dao.DuckMapper;
import com.duck.pojo.Duck;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-06
 * Time: 12:33
 */
public class DuckServiceImpl implements DuckService {

    private DuckMapper duckMapper;

    public void setDuckMapper(DuckMapper duckMapper) {
        this.duckMapper = duckMapper;
    }

    public List<Duck> select() {
        return duckMapper.select();
    }

    public int insert(Duck duck) {
        return duckMapper.insert(duck);
    }

    public int update(Duck duck) {
        return duckMapper.update(duck);
    }

    public int delete(String id) {
        return duckMapper.delete(id);
    }

    public List<Duck> selectByLike(String keyWords) {
        return duckMapper.selectByLike(keyWords);
    }

    public List<Duck> selectByRange(Map<String, Object> map) {
        return duckMapper.selectByRange(map);
    }

    public Duck selectOne(String id) {
        return duckMapper.selectOne(id);
    }
}
