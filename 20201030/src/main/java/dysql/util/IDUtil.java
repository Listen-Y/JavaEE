package dysql.util;
import java.util.UUID;
/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2020-10-30
 * Time: 10:07
 */
public class IDUtil {

    public static String getIdUtil() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
