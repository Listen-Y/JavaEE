package util;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 14:24
 */
public class OrderSystemUtil {

    public static String readBody(HttpServletRequest request) throws UnsupportedEncodingException {
        int length = request.getContentLength();
        byte[] body = new byte[length];
        try (InputStream inputStream = request.getInputStream()) {
            inputStream.read(body, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 此处有一个重要的注意事项!!! 构造 String 的时候, 必须要指定
        // 该字符串的编码方式. (这个操作相当于就是把字节数据转成字符数据)
        // 涉及到这样的转换, 最好都加上编码方式.
        // 如果一定 10不加, 不0% 出错, 有一定的风险.
        return new String(body, StandardCharsets.UTF_8);
    }

}
