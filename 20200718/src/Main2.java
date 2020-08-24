import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2{
    public static void main(String []args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null) {
            String word=br.readLine();
            System.out.println(jiami(str));
            System.out.println(jiemi(word));
        }
    }
    public static String jiami(String str) {
        char[] ch =str.toCharArray();
        StringBuilder sb=new StringBuilder();

        for (char c : ch) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'z')
                    sb.append('A');
                else
                    sb.append((char) (c - 32 + 1));

            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'Z')
                    sb.append('a');
                else
                    sb.append((char) (c + 32 + 1));
            } else if (c >= '0' && c <= '9') {
                if (c == '9')
                    sb.append('0');
                else
                    sb.append(c - '0' + 1);

            }

        }

        return sb.toString();
    }

    public static String jiemi(String str) {
        char[] ch =str.toCharArray();
        StringBuilder sb=new StringBuilder();

        for (char c : ch) {
            if (c >= 'a' && c <= 'z') {
                if (c == 'a')
                    sb.append('Z');
                else
                    sb.append((char) (c - 32 - 1));

            } else if (c >= 'A' && c <= 'Z') {
                if (c == 'A')
                    sb.append('z');
                else
                    sb.append((char) (c + 32 - 1));
            } else if (c >= '0' && c <= '9') {
                if (c == '0')
                    sb.append('9');
                else
                    sb.append(c - '0' - 1);

            }

        }

        return sb.toString();
    }



}