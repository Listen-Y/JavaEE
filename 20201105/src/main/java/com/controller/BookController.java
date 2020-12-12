package com.controller;

import com.pojo.Books;
import com.service.BookService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-11-05
 * Time: 12:18
 */
@Controller
@RequestMapping("/book")
public class BookController {


    final
    BookService service;

    public BookController(@Qualifier("booksMapperImpl") BookService service) {
        this.service = service;
    }


    //查询全部书籍,并且返回到一个展示页面
    @RequestMapping("/all")
    public String addBook(Model model) {
        List<Books> list = service.selectBooks();
        model.addAttribute("msg", list);
        return "allBook";
    }

    //删除一本书
    @RequestMapping("/de")
    public ModelAndView delete(int id, ModelAndView model) {
        model.addObject("msg", service.delete(id) == 1 ? "删除成功" : "删除失败");
        model.setViewName("");
        return model;
    }

    //新增一本书
    @RequestMapping("/add/{key}/")
    public String addBook(@PathVariable int key, Books books) {
        if (key == 1) {
            return "addBook";
        }

        service.insert(books);

        return "redirect:/book/all";
    }

    //修改书籍
    @RequestMapping("/update/{bookID}/{key}")
    public String update(@PathVariable int bookID, @PathVariable int key, Model model, Books books) {
        if (key == 1) {
            //跳转到修改页面
            Books query = service.query(bookID);
            model.addAttribute("book", query);
            return "updateBook";
        }
        service.update(books);
        //重定向到首页
        return "redirect:/book/all";
    }


    //删除书籍
    @RequestMapping("/delete")
    public String delete(int bookID) {
        /*String bookID = request.getParameter("bookID");*/
        service.delete(bookID);
        return "redirect:/book/all";
    }

    //模糊查询
    @RequestMapping("/like")
    public String like(String keyWords, Model model) {
        System.out.println();
        if (keyWords == null) {
            keyWords = "";
        }
        List<Books> list = service.selectBooksByLike("%" + keyWords + "%");
        if (list.size() == 0) {
            model.addAttribute("ERROR", "未查到");
        } else {
            model.addAttribute("msg", list);
        }
        return "allBook";
    }
}
