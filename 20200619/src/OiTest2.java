import java.io.*;

public class OiTest2 {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {
        try (BufferedInputStream bufferedInputStream
                     = new BufferedInputStream(new FileInputStream("D:\\java\\test\\more\\flower.png"));
             BufferedOutputStream bufferedOutputStream
                     = new BufferedOutputStream(new FileOutputStream("D:\\java\\test\\more\\flower2.png", true))){


            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println("复制成功");
    }
}
