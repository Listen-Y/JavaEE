package todayTest.application.modle;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-18
 * Time: 10:41
 */
//这是一个统一的返回数据格式
@Getter
@Setter
@ToString
public class ReturnFormat {

    private boolean success; //请求是否成功
    private Object data;  //成功返回的数据
    private String code;  // 错误的话返回的提示信息
    private String message;  //描述

    public void setSuccess(boolean b) {
    }

    public void setData(Object o) {
    }

    public void setMessage(String 返回的是我们自定义的格式) {
    }
}
