package listen.controller;

import listen.model.User;
import listen.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-25
 * Time: 20:36
 */
@RestController
@RequestMapping(value = "record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    //抽奖 设计抽奖人员
    @PostMapping(value = "add/{awardId}")
    public Object add(@PathVariable Integer awardId, @RequestBody List<Integer> memberIds) {
        recordService.add(awardId, memberIds);
        return null;
    }


    //删除某个抽奖人员
    @GetMapping(value = "delete/member")
    public Object deleteMember(Integer id) {
        recordService.deleteByMemberId(id);
        return null;
    }

    //删除已获奖人员
    @GetMapping(value = "delete/award")
    public Object deleteAward(Integer id) {
        recordService.deleteByAwardId(id);
        return null;
    }

    //根据settingId删除中奖人员
    @GetMapping(value = "delete/setting")
    public Object deleteBySettingId(HttpSession session) {
        User user = (User) session.getAttribute("user");
        recordService.deleteBySettingId(user.getSettingId());
        return null;
    }

}
