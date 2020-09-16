package todayTest.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import todayTest.application.modle.DiyException;
import todayTest.application.modle.Person;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-17
 * Time: 10:10
 */
//当前类型注册实例到容器中，并指定为Web请求的处理
@Controller
//@RequestMapping可以定义请求相关的配置：如路径，请求方法等等
@RequestMapping("/per")
public class PersonController {

    @Resource
    //@AutoWired 使用这个也是可以的
    //以我们设置的变量名去查找初始化好的bean对象
    private Map<String, String> test1;


    @RequestMapping(value = "/test1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = {RequestMethod.GET})
    //设置web请求的访问路径
    // produces设置返回的数据格式是uft-8
    // method设置可以访问的http方法为get
    @ResponseBody
    //设置以json格式返回结果
    public Object test1() {
        return test1;
    }

    //使用@Resource时
    @Resource(name = "person1")
    private Person person;

    @RequestMapping(value = "test2")
    @ResponseBody
    public Object test2() {
        return person;
    }

    //使用@Autowired时
    @Autowired
    @Qualifier(value = "person2")
    private Person person3;

    @RequestMapping(value = "test3")
    @ResponseBody
    public Object test3() {
        return person3;
    }

    @RequestMapping(value = "test4")
    public String test4() {
        //返回路径，不带/：以当前请求路径为相对位置，查找同一级资源
        // 带/，会去掉这个当前路径，以项目的部署路径为相对位置
        return "/ok.html";
    }

    @RequestMapping(value = "test5")
    public String test5() {
        return "forward:test1";
    }

    @RequestMapping(value = "test6")
    public String test6() {
        return "redirect:test2";
    }

    //url为rest风格的请求
    @RequestMapping(value = "test7/{key}")//路径中使用变量占位符
    @ResponseBody
    public Object test7(@PathVariable("key") Integer k) { //如果类型不匹配会抛出异常
        return k;
    }

    //请求GET /per/test8?k1=1&k2=2&k3=3
    @RequestMapping(value = "test8", method = {RequestMethod.GET})
    @ResponseBody
    public Object test8( //可以匹配url中的参数，请求体k1=v1&k2=v2格式的数据
                         //x-www-form-urlencoded和form-data的请求数据格式，都可以
                         @RequestParam("k1") String ksss,//写全的做法，通过注解值为key查找请求数据
                         @RequestParam String k2,//省略注解值的做法，默认以变量名为key查找请求数据
                         String k3 //最省略的做法：默认就是@RequestParam注解
    ) {
        return ksss + "," + k2 + "," + k3;
    }

    //请求数据自动映射到参数类型的属性中：/per/test9?name=詹姆斯&Id=123456789&age=37
    @RequestMapping(value = "test9", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object test9(Person person) {
        return person;
    }


    //http请求是基于Servlet的，Spring已经生成了request和response对象，可以直接在参数中使用
    @RequestMapping(value = "test10", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object test6(HttpServletRequest req, HttpServletResponse res) {//Spring自动的将对象注入到参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //还可以通过这个设置cookie
        HttpSession session = req.getSession(true);
        if (session.isNew()) {
            session.setAttribute("password", "password");
        }
        return "username:" + username + "," + "password" + password;
    }

    //请求数据类型为application/json时，解析请求体中的json字符串为java对象
    @RequestMapping(value = "test11", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object test11(@RequestBody Person person) {
        return person;
    }


    //访问test12直接返回自定义异常
    @RequestMapping(value = "test12")
    public Object test12() throws DiyException {
        throw new DiyException("这是一个自定义异常");
    }

    //web请求访问这里我们直接返回一个bean对象 然后使用统一数据格式对其进行封装
    @RequestMapping(value = "test13", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object test13() {
        return test1;
    }

    //这这里表示进行一个登录
    @RequestMapping(value = "test14")
    @ResponseBody
    public Object test14(HttpServletRequest request) throws DiyException {
        HttpSession session = request.getSession(true);
        if (session.isNew()) {
            //之前未进行登录
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            return "登录成功";
        }
        //之前已经登录过了
        throw new DiyException("已经登录");
    }

}
