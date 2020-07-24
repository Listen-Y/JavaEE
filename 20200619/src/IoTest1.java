

import java.io.*;

public class IoTest1 {
    public static void main(String[] args) {
        copyFile();
        copyFileBuffer();
    }

    private static void copyFile() {
        long beg = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("D:\\java\\test\\more\\flower.png");
             FileOutputStream fileOutputStream = new FileOutputStream("D:\\java\\test\\more\\flower2.png")){

            byte[] buffer = new byte[1];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println("复制成功");
        long end = System.currentTimeMillis();
        System.out.println("无buffer的时间为" + (end - beg) + "ms");
    }

    private static void copyFileBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream
                     = new BufferedInputStream(new FileInputStream("D:\\java\\test\\more\\flower.png"));
             BufferedOutputStream bufferedOutputStream
                     = new BufferedOutputStream(new FileOutputStream("D:\\java\\test\\more\\flower3.png"))){


            byte[] buffer = new byte[1];
            int len = -1;
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println("复制成功");
        long end = System.currentTimeMillis();
        System.out.println("有buffer的时间为" + (end - beg) + "ms");
    }
}
