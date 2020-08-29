package listen.service;

import listen.mapper.RecordMapper;
import listen.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:13
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public void add(Integer awardId, List<Integer> memberIds) {
        recordMapper.batchAdd(awardId, memberIds);
    }

    @Transactional
    public void deleteByMemberId(Integer id) {
        Record record = new Record();
        record.setMemberId(id);
        recordMapper.deleteByCondition(record);
    }

    public void deleteByAwardId(Integer id) {
        Record record = new Record();
        record.setAwardId(id);
        recordMapper.deleteByCondition(record);
    }

    public void deleteBySettingId(Integer settingId) {
        recordMapper.deleteBySettingId(settingId);
    }
}
