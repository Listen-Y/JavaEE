package todayTest.application.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import todayTest.application.modle.DiyException;
import todayTest.application.modle.ReturnFormat;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-18
 * Time: 10:24
 */
//指名身份, 这是一个拦截Controller中web请求进行统一处理的类
@ControllerAdvice
//实现ResponseBodyAdvice接口实现统一数据的封装
//注意要设置为Object类型
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {

    //指定处理请求方法中抛出的异常
    @ExceptionHandler(DiyException.class)
    @ResponseBody
    public Object handler(DiyException d) {
        return d.getMessage();
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //执行Controller中的web请求方法结束，返回数据到前端的时候，是否要重写响应体
        //如果返回的是true就是要执行重写 反之不重写
        //这里我们方便演示就让全部数据都要按照我们的自定义格式返回数据
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //如果存在返回字符串的情况，需要返回字符串类型，否则会报错
        //解决方案：判断o对象的类型：
        //如果是字符串，就返回objectmapper序列化后的字符串，否则返回统一封装的类型

        if (o.getClass().equals(String.class)) {
            //判断是字符串类型将数据以json格式返回
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(o);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        //在这里我们统一返回我的自定义的ReturnFormat格式 将数据封装到这个格式里
        // o就是我们返回的数据
        ReturnFormat returnFormat = new ReturnFormat();
        returnFormat.setSuccess(true);
        returnFormat.setData(o);
        returnFormat.setMessage("返回的是我们自定义的格式");
        return returnFormat;
    }
}
