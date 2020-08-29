package listen.controller;

import listen.model.User;
import listen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 17:17
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;


    //登录管理
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public Object login(@RequestBody User user, HttpServletRequest request) {
        //调用userService中的方法判断
        User exist = userService.login(user);
        // 如果没有报异常说明数据是正常的
        HttpSession session = request.getSession(true);
        session.setAttribute("user", exist);
        return null;
    }

    //注册管理
    @PostMapping(value = "register")
    public Object register(User user, @RequestPart(value = "headFile", required = false) MultipartFile headFile) {
        userService.register(user, headFile);
        return null;
    }

    //实现注销
    @RequestMapping(value = "logout")
    public Object logout(HttpServletRequest request) {
        //拦截器并没有拦截这个路径
        userService.logout(request);
        return null;
    }
}
