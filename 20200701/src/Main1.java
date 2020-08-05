import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main1 {

    public static void main1(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1;
        String line2;
        while ((line1 = br.readLine()) != null && (line2 = br.readLine()) != null) {
            String[] IP1 = line1.split("\\.");
            long IP2 = Long.parseLong(line2);

            System.out.println(Long.parseLong(IP1[0]) << 24 | Long.parseLong(IP1[1]) << 16 |
                    Long.parseLong(IP1[2]) << 8 | Long.parseLong(IP1[3]));

            String sb = ((IP2 >> 24) & 255) + "." + ((IP2 >> 16) & 255) +
                    "." + ((IP2 >> 8) & 255) + "." + (IP2 & 255);
            System.out.println(sb);

        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入IP地址:");
        String ipStr = scanner.nextLine();
        System.out.print("输入数字:");
        long ipLong = Long.parseLong(scanner.nextLine());

        System.out.println(ipToLong(ipStr));

        System.out.println(longToIp(ipLong));


    }
    //将ip地址转换成数字
    public static long ipToLong(String ip) {

        String[] ipPart = ip.split("\\.");

        long ipNum = Long.parseLong(ipPart[0]) << 24 | Long.parseLong(ipPart[1])
                << 16 | Long.parseLong(ipPart[2]) << 8 | Long.parseLong(ipPart[3]);

        return ipNum;
    }
    //将数字转换成ip地址
    public static String longToIp(long ip2) {

        String ipStr = ((ip2 >> 24) & 255) + "." + ((ip2 >> 16) & 255) + "." +
                ((ip2 >> 8) & 255) + "." + ((ip2) & 255);

        return ipStr;
    }
}