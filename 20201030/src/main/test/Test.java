import dysql.dao.BlogDao;
import dysql.model.Blog;
import dysql.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 10:22
 */
public class Test {

    /*
        private String id;
    private String title;
    private String author;
    private Timestamp createTime;
    private int views;
     */

    private SqlSession sqlSession;

    @org.junit.Test
    public void selectBlog() {
        for (Blog blog : getBlogDao().selectBlog()) {
            System.out.println(blog);
        }
        close();
    }

    @org.junit.Test
    public void insert() {
        getBlogDao().insert(new Blog("4", "美滋滋", "bike",
                new Timestamp(new Date().getTime()), 9998));
        close();
    }

    @org.junit.Test
    public void selectNeed() {
        Map<String, Object> map = new HashMap<>();
        map.put("title", "爽歪歪歪");
        //map.put("author", "bike");
        map.put("views", 9998);
        for (Blog blog : getBlogDao().selectBlogNeed(map)) {
            System.out.println(blog);
        }
        close();
    }

    @org.junit.Test
    public void selectChoose() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        //map.put("title", "爽歪歪");
        //map.put("author", "bike");
        for (Blog blog : getBlogDao().selectBlogChoose(map)) {
            System.out.println(blog);
        }
        close();
    }


    @org.junit.Test
    public void update() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 3);
        map.put("newTitle", "爽歪歪");
        map.put("title", "爽歪歪歪");
        map.put("newAuthor", "Faker");
        getBlogDao().update(map);
        close();
    }

    @org.junit.Test
    public void selectForEach() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        for (Blog selectBlogForEach : getBlogDao().selectBlogForEach(list)) {
            System.out.println(selectBlogForEach);
        }
        close();
    }

    private BlogDao getBlogDao() {
        sqlSession = DBUtil.getSqlSession();
        return sqlSession.getMapper(BlogDao.class);
    }

    private void close() {
        sqlSession.close();
    }
}
