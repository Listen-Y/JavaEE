package listen.controller;

import listen.model.Member;
import listen.model.User;
import listen.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-25
 * Time: 19:48
 */
@RestController
@RequestMapping(value = "member")
public class MemberController {

    //注入对象
    @Autowired
    private MemberService memberService;

    //添加一个成员
    @PostMapping(value = "add")
    public Object add(@RequestBody Member member, HttpSession session) {
        User user = (User) session.getAttribute("user");
        member.setUserId(user.getId());
        memberService.add(member);
        return null;
    }

    //修改成员信息
    @PostMapping(value = "update")
    public Object update(@RequestBody Member member) {
        memberService.update(member);
        return null;
    }

    //删除抽奖人员
    @GetMapping(value = "delete/{id}")
    public Object delete(@PathVariable Integer id) {
        memberService.delete(id);
        return null;
    }
}
