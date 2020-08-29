package listen.mapper;

import listen.base.BaseMapper;
import listen.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}