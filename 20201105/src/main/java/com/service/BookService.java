package com.service;

import com.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-05
 * Time: 10:44
 */
public interface BookService {

    int insert(Books book);
    int delete(int bookID);
    int update(Books books);
    Books query(int id);
    List<Books> selectBooks();
    List<Books> selectBooksByLike(String keyWords);
}
