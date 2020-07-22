import java.io.File;

public class IOTest4 {

    public static void main(String[] args) {

        File file = new File("D:\\java");
        listAllFiles(file);

       /* File[] files = file.listFiles();

        for (File f : files
             ) {
            System.out.println(f);
        }*/
    }

    private static void listAllFiles(File file) {

        if (file.isDirectory()) {
            //如果是目录 就获得其目录的所有组成
            File[] files = file.listFiles();

            //递归遍历所有组成
            assert files != null;
            for (File f : files
                 ) {
                listAllFiles(f);
            }
        } else {
            //说明是文件就输出其路径
            System.out.println(file);
        }
    }
}
