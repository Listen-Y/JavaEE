package listen.mapper;

import listen.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-21
 * Time: 22:57
 */
@Mapper
public interface TestMapper {

    User query(Integer id);
}
