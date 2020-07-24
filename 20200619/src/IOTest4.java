import java.io.*;

public class IOTest4 {
    public static void main(String[] args) {
        copyFile();
    }

    private static void copyFile() {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\java\\test\\more\\NBA.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\java\\test\\more\\NBA2.txt", true))){

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                //每次读入一行要换行 给line加 “\n" 或者下面这种都行
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

        System.out.println("复制成功");
    }
}
