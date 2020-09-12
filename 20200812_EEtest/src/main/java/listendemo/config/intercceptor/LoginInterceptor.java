package listendemo.config.intercceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import listendemo.modle.RespondResult;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-16
 * Time: 15:13
 */
//拦截器
    //只有匹配的路径拦截路径要去访问他的路径的时候 才会使用到这个拦截器
public class LoginInterceptor implements HandlerInterceptor {

    private ObjectMapper objectMapper;

    public LoginInterceptor(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    /*
    Controller中请求方法执行前 会调用preHandle 返回值决定是否继续执行controller中的方法
    如果是true则是继续执行
    false则不执行了
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            //表示此时是登陆状态 可以访问
            return true;
        }
        //没有登陆 可以用过response对象返回一个结果
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        RespondResult r = new RespondResult();
        r.setCode("REEOR 401");
        r.setMessage("未登录不可访问");
        String jsonStr = objectMapper.writeValueAsString(r);
        response.getWriter().write(jsonStr);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
