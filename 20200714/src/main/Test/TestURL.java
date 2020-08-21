import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class TestURL {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "%E5%BF%98%E5%AE%8C";
        s = URLDecoder.decode(s, "utf-8");
        System.out.println(s);
    }
}
