import javax.servlet.http.Part;
import java.io.File;

public class Main {
    public static void main(String[] args) {
       // System.out.println(getLCA(8, 11));
        String loadPath = "D:\\java\\test";
        File file = new File(loadPath);
        //获取文件，文件在html中的name是“file”
        String part = "cat.png";
        //制作文件全路径
        String path = file.getName() + File.separator + part;
        System.out.println(part);
    }

    public static int getLCA(int a, int b) {
        // write code here
        if (a == b) {
            return a;
        }
        return a > b ? getLCA(a / 2, b) : getLCA(a, b / 2);
    }
}
