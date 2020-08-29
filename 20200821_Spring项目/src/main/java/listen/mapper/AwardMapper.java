package listen.mapper;

import listen.base.BaseMapper;
import listen.model.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {
    List<Award> query(Award award);
}