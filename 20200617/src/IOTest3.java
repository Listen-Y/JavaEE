import javax.xml.crypto.Data;
import java.io.File;
import java.util.Date;

public class IOTest3 {

    public static void main(String[] args) {

        String path = "D:\\java\\test\\more\\";
        String name = "moreTest.txt";

        File file = new File(path + name);

        //获得文件字节大小
        System.out.println("moreTest.txt" + "大小为" + file.length());

        //最近修改时间
        System.out.println("moreTest.txt最近修改时间为" + new Date(file.lastModified()));
    }
}
