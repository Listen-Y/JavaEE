package listen.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-24
 * Time: 13:14
 */
@Setter
@Getter
// 系统异常
public class SystemException extends BaseException {
    public SystemException(String code, String message) {
        super("SYS" + code, message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super("SYS" + code, message, cause);
    }
}
