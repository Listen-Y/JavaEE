import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest3 {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {

        try (FileReader fileReader = new FileReader("D:\\java\\test\\more\\NBA.txt");
             FileWriter fileWriter = new FileWriter("D:\\java\\test\\more\\NBA2.txt")){

            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer, 0, len);

            }

        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
