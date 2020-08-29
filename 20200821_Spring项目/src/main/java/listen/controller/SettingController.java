package listen.controller;

import listen.model.Setting;
import listen.model.User;
import listen.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 22:45
 */
@RestController
@RequestMapping(value = "setting")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping(value = "query")
    public Object query(HttpSession session) {
        //在这里一定是登录成功的 所以一定是有session的 而且一定是包含user的
        // 否则拦截器会把这个路径拦下
        User user = (User) session.getAttribute("user");
        Setting setting = settingService.query(user.getId());
        user.setSettingId(setting.getId());
        setting.setUser(user);
        return setting;
    }

    //修改抽奖人数
    @GetMapping(value = "update")
    public Object update(Integer batchNumber, HttpSession session) {
        User user = (User) session.getAttribute("user");
        settingService.update(user.getId(), batchNumber);
        return null;
    }
}
