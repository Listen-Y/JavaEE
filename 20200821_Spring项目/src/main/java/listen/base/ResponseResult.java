package listen.base;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 12:55
 */
@Getter
@Setter
// 返回数据的统一包装类型
public class ResponseResult {

    private boolean success;
    private Object data;
    private String code;
    private String message;


    public ResponseResult() {
    }

    public static ResponseResult ok(Object data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.data = data;
        responseResult.success = true;
        return responseResult;
    }

    public static ResponseResult error(String code, String message) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.success = false;
        responseResult.code = code;
        responseResult.message = message;
        return responseResult;
    }

    public static ResponseResult error() {
        return error("ERR000", "未知错误");
    }

}
