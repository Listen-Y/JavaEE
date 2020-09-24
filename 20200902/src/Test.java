import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-02
 * Time: 14:03
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/test/");
        System.out.println(file.isDirectory());
        System.out.println(file.exists());
        if (file.mkdir()) {
            System.out.println(file.isDirectory());
            System.out.println(file.exists());
        }
       /* FileOutputStream fileOutputStream = new FileOutputStream(file + "/study.txt");
        String s = "hahaha";
        fileOutputStream.write(s.getBytes());*/
    /*    FileInputStream fileInputStream = new FileInputStream(file + "/study.txt");
        byte[] bytes = new byte[1024];
        int length = fileInputStream.read(bytes);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(bytes[i]);
        }
        System.out.println(builder.toString());*/
/*    FileReader fileReader = new FileReader(file + "/study.txt");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    String ret = bufferedReader.readLine();
        System.out.println(ret);
        bufferedReader.close();
        fileReader.close();*/
GUITest guiTest = new GUITest();
    }
}
