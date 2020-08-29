package listen.service;

import listen.exception.BusinessException;
import listen.mapper.SettingMapper;
import listen.model.Award;
import listen.model.Member;
import listen.model.Setting;
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
public class SettingService {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private AwardService awardService;

    @Autowired
    private MemberService memberService;

    public Setting query(Integer id) {

        //在注册用户时就会创建一个setting 如果此时找不到就说明业务有问题
        Setting query = new Setting();
        query.setUserId(id);
        Setting setting = settingMapper.selectOne(query);
        if (setting == null) {
            throw new BusinessException("SET001", "用户设置信息错误");
        }
        //查询获奖列表设置到setting中
        Award award = new Award();
        award.setSettingId(setting.getId());
        List<Award> awards = awardService.query(award);
        setting.setAwards(awards);
        //查询用户设置的人员列表
        Member member = new Member();
        member.setUserId(id);
        List<Member> members = memberService.query(member);
        setting.setMembers(members);
        return setting;
    }


    //修改抽奖人数
    //Spring事务设置：默认的传播方式为Required，当前没有事务，就创建，有就加入
    @Transactional
    public void update(Integer id, Integer batchNumber) {
        int num = settingMapper.updateByUserId(id, batchNumber);
    }

    @Transactional
    public void add(Setting setting) {
        settingMapper.insertSelective(setting);
    }
}
