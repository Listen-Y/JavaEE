package listendemo.modle;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-16
 * Time: 14:37
 */
@Getter
@Setter
@ToString
public class RespondResult {

    private boolean success;
    private Object data; // 为true需要的业务数据
    private String code; // 为false的错误码信息
    private String message;

}
