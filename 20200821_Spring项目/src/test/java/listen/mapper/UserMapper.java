package listen.mapper;

import listen.base.BaseMapper;
import listen.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}