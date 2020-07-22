import java.io.File;

public class IOTest2 {

    public static void main(String[] args) {

        String path = "D:\\java\\test\\more";
        //要创建的目录
        String dir = "\\dir1\\dir2\\dir3";
        String pathname = path + dir;

        File file = new File(pathname);

        System.out.println("file是否存在" +file.exists());
        System.out.println("创建成功"+ file.mkdirs());
        System.out.println("file是否存在" +file.exists());

        System.out.println("获得父路径" + file.getParent());

        File filePar = file.getParentFile();
        System.out.println("获得父对象" + filePar);
    }
}
