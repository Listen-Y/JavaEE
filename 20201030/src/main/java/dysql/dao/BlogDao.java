package dysql.dao;

import dysql.model.Blog;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 9:53
 */
public interface BlogDao {

    List<Blog> selectBlog();

    int insert(Blog blog);

    List<Blog> selectBlogNeed(Map<String, Object> map);

    List<Blog> selectBlogChoose(Map<String, Object> map);

    int update(Map<String, Object> map);

    List<Blog> selectBlogForEach(List<Integer> list);

}
