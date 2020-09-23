import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-02
 * Time: 22:02
 */
public class Test {

    public static void main(String[] args) {
        Reptiles reptiles = new Reptiles();
        System.out.println("===正能量爬虫工具启动===");
        System.out.println();
        System.out.print("输入你要爬取图片的关键字:");
        Scanner scanner = new Scanner(System.in);
        String kewWorlds = scanner.nextLine();
        reptiles.pictureReptiles(kewWorlds);
    }
}
