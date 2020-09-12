package listendemo.UserController;

import listendemo.modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-12
 * Time: 21:09
 */
@Controller
//Controller表示当前类型注册到容器中 并指定为web请求的处理
@RequestMapping("/user")
//RequestMapping可以配置定义请求的相关的配置 如路径 请求方法等
public class UserController {

    //@Autowired
    //上面这个是属于Spring框架
    @Resource
    //这个是属于JDK提供的注解 表示资源 JDK只提供了规范, 没有提供实现
    private Map<Integer, Integer> test;

    @Resource
    private User user1;

   @Resource(name = "user2") //如果变量名与bean的名称不一样 @Resource要指定name为bean的名称
    private User user;

    //如果是使用@AutoWired遇到这种一个类型有多个实例对象的时候 默认查找bean的名称为变量名的bean
    //和使用Resource差不多 但是使用AutoWired要搭配Qualifier使用
    @Autowired
    @Qualifier("user1")
    private User user3;

    //如果有乱码设置成produces的utf-8格式
    @RequestMapping(value = "/login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    //返回一个application/json的数据类型 返回值会序列化为json字符串
    public Object login(User user, HttpServletRequest request) {
        /*Map<String, String> map = new HashMap<>();
        map.put("man", "listen");
        map.put("gril", "love");
        return map;*/
        if (!"abc".equals(user.password)) {
            return user.toString();
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        return user;
    }

    @RequestMapping("/m")
    public String m() {
        //这里是属于转发
        return "/main.html";
    }

    //这是转发的写法 就是会把返回路径下的资源转发到我们当前的路径
    @RequestMapping("/l")
    public String l() {
        //返回路径开头带/的话会去掉当前得路径 以项目的部署路径为准
        //返回的路径开头不带/就会以当前路径查找同一级资源
        return "forward:/user/login";
    }

    //这是重定向的写法 页面会跳转到我们返回的路径
    @RequestMapping("/ll")
    public String ll() {
        return "redirect:/user/login";
    }

    //url为rest风格 路径中带有变量占用符为数据
    @RequestMapping("/test/{key}")
    @ResponseBody
    public Object test1(@PathVariable("key") Integer key) {
        return key;
    }

    //url中带有?后面有数据 而且这个不仅可以得到url中k1=v1&k2=v2  还可以得到post中的 只需要改mapping就行
    //如果不指定method默认是get
    @RequestMapping(value = "/test2", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    //下面这个RequestParam可以带括号指定指定名字查找   也可以连RequestParam省略 默认就是这个注解
    public Object test2(@RequestParam String k1, String k2) {
        return k1 + "," + k2;
    }

    //请求的数据自动映射到参数类型的属性中 username=xxx&password=xxx
    //
    @RequestMapping("/test3")
    @ResponseBody
    public Object test3(User user) {
        return user.toString();
    }

    //返回响应体为空
    @RequestMapping("/test4")
    @ResponseBody
    public Object test4() {
        return null;
    }

    //返回响应体为字符串 并没有转成json格式 而且原字符串
    // 也就是不是application/json格式 而且text/plain
    @RequestMapping("/test5")
    @ResponseBody
    public Object test5() {
        return "ok";
    }

    @RequestMapping("/test6")
    @ResponseBody
    //http请求是基于servlet的 spring已经生成了request对象和response对象可以直接用
    //spring自动的将参数注入到对象中
    public Object test6(HttpServletRequest request ,HttpServletResponse response) throws IOException {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        return name + "," + password;
    }

    //将Post请求中的body中的json数据注入到user对象中
    @RequestMapping(value = "/test7", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public Object test7(@RequestBody User user) {
        return user.toString();
    }

    @RequestMapping("/test8")
    @ResponseBody
    public Object test8() {
        throw new RuntimeException("这是一个异常");
    }

    /*
    web开发的需要
    1. 统一数据格式
    2. 统一异常处理
    3. 统一会话管理
     */

}
