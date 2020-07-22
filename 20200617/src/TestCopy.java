import java.io.*;

public class TestCopy {

    public static void main(String[] args) {

        File fileIn = new File("D:\\java\\test\\more\\flower.png");
        File fileOut = new File("D:\\java\\test\\more\\flower2.png");

        //如果不存在这个文件就把他新建出来
        if (!fileOut.exists()) {
            try {
                System.out.println(fileOut.createNewFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            fileCopy(fileIn, fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileCopy(File fileIn, File fileOut) throws IOException {

            //打开文件才能读入
            FileInputStream inputStream = new FileInputStream(fileIn);
            FileOutputStream outputStream = new FileOutputStream(fileOut);

            byte[] bytes = new byte[1024];

            int len = -1;

        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);

        }

        //关闭流文件
        outputStream.close();
        inputStream.close();

    }
}
