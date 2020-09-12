package listendemo.config;

import listendemo.modle.RespondResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-16
 * Time: 14:20
 */
//指定身份 拦截controller中web请求类中的异常
@ControllerAdvice
public class AppControllerAdvice implements ResponseBodyAdvice<Object> {

    @ExceptionHandler
    @ResponseBody
    public Object handle(Exception e) {
        return e.getMessage();
    }


    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true; // 在Controller的web中方法执行结束的的时候 判断是否需要重写响应体
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        RespondResult respondResult = new RespondResult();
        respondResult.setSuccess(true);
        respondResult.setData(o);
        return respondResult;
    }
}
