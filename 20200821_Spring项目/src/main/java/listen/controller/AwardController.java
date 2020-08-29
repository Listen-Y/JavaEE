package listen.controller;

import listen.model.Award;
import listen.model.User;
import listen.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-25
 * Time: 19:21
 */
@RestController
@RequestMapping(value = "award")
public class AwardController {

    //注入
    @Autowired
    private AwardService awardService;

    //新增奖项
    @RequestMapping(value = "add")
    public Object add(@RequestBody Award award, HttpSession session) {
        User user = (User) session.getAttribute("user");
        //此时这个奖项还不知道是哪个抽奖任务的 需要给他设置settingId
        award.setSettingId(user.getSettingId());
        awardService.add(award);
        return null;
    }

    //修改奖项
    @RequestMapping(value = "update")
    public Object update(@RequestBody Award award) {
        awardService.update(award);
        return null;
    }

    //删除一个奖项
    @GetMapping(value = "delete/{id}")
    public Object delete(@PathVariable Integer id) {
        awardService.delete(id);
        return null;
    }
}
