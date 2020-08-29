package listen.service;

import listen.mapper.MemberMapper;
import listen.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:12
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> query(Member member) {

        return memberMapper.selectByCondition(member);

    }

    //添加事务 以防出现数据错误
    @Transactional
    public void add(Member member) {
        memberMapper.insertSelective(member);
    }

    @Transactional
    public void update(Member member) {
        memberMapper.updateByPrimaryKeySelective(member);
    }

    @Transactional
    public void delete(Integer id) {
        memberMapper.deleteByPrimaryKey(id);
    }
}
