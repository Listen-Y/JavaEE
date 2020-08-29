package listen.service;

import listen.mapper.AwardMapper;
import listen.model.Award;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:11
 */
@Service
public class AwardService {

    @Autowired
    private AwardMapper awardMapper;

    public List<Award> query(Award award) {

        return awardMapper.query(award);

    }

    public void add(Award award) {
        awardMapper.insert(award);
    }

    public void update(Award award) {
        awardMapper.updateByPrimaryKeySelective(award);
    }

    public void delete(Integer id) {
        awardMapper.deleteByPrimaryKey(id);
    }
}
