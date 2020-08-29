package listen.mapper;

import listen.base.BaseMapper;
import listen.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    //自定义设定MyBatis方法,如果有多个变量需要指定@Param("name")
    int batchAdd(@Param("awardId") Integer awardId, @Param("memberIds") List<Integer> memberIds);

    void deleteByCondition(Record r);

    int deleteBySettingId(Integer id);
}