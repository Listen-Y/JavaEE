import java.io.File;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) {
        String path = "D:\\java\\test\\more";
        String pathname = path + "\\moreTest.txt";
        File file = new File(pathname);

        //判断是否存在
        System.out.print("判断是否存在");
        System.out.println(file.exists());

        //如果存在就查看是否为目录或者文件
        if (file.exists()) {
            //判断是否目录
            System.out.println("判断是否目录" + file.isDirectory());
            //判断是否文件
            System.out.println("判断是否文件" + file.isFile());
        }

        //删除文件
        System.out.print("删除文件");
        System.out.println(file.delete());

        if(!file.exists()){
             System.out.println("删除文件成功！");
        } else {
             System.out.println("删除文件失败！");
        }


        //创建文件
        if (! file.exists()) {
            try {
                System.out.print(file.createNewFile());
                System.out.println("创建成功");
            } catch (IOException e) {
                System.out.println("创建失败");
            }
        } else {
            System.out.println("file存在不需要创建");
        }

        System.out.println("最后file是否存在" + file.exists());
    }
}
