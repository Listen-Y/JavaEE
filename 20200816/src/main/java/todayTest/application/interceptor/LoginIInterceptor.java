package todayTest.application.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import todayTest.application.modle.ReturnFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-18
 * Time: 13:54
 */
//如果拦截到路径会来到这里
    //这里要实现HandlerInterceptor接口
public class LoginIInterceptor implements HandlerInterceptor {

    /**
     * Controller中请求方法执行前，就会调用preHandle，返回值决定是否在继续执行Controller中的方法
     * return true：继续执行Controller中的方法
     * return false：不执行了
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //这里实现的是一个登录会话管理
        //我将获取request中的session
        // 如果没有session表示他未进行登录就无法访问我们拦截到的这个路径
        // 然后返回false 就不会执行Controller中的方法
        HttpSession session = request.getSession(false);
        if (session != null) {
            //进行了登录
            return true;
        }
        //未进行登录
        ReturnFormat returnFormat = new ReturnFormat();
        returnFormat.setSuccess(false);
        returnFormat.setCode("ERROR");
        returnFormat.setMessage("无法访问,请先登录");
        response.setContentType("application/json; charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(returnFormat);
        response.getWriter().write(jsonStr);
        return false;
    }
}
