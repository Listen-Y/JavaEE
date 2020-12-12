package com.service;

import com.dao.BookMapper;
import com.pojo.Books;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-05
 * Time: 10:44
 */
public class BookServiceImpl implements BookService {

    private BookMapper bookMapper;

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    public int insert(Books book) {
        return bookMapper.insert(book);
    }

    public int delete(int bookID) {
        return bookMapper.delete(bookID);
    }

    public int update(Books books) {
        return bookMapper.update(books);
    }

    public Books query(int id) {
        return bookMapper.query(id);
    }

    public List<Books> selectBooks() {
        return bookMapper.selectBooks();
    }

    public List<Books> selectBooksByLike(String keyWords) {
        return bookMapper.selectBooksByLike(keyWords);
    }
}
