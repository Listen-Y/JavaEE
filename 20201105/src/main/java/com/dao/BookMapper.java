package com.dao;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-05
 * Time: 10:20
 */
public interface BookMapper {

    int insert(Books book);
    int delete(@Param("bookID") int bookID);
    int update(Books books);
    Books query(@Param("id") int id);
    List<Books> selectBooks();

    //模糊查询
    List<Books> selectBooksByLike(String keyWords);
}
