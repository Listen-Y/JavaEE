import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-15
 * Time: 22:13
 */
public class Test {

    public static void main(String[] args) throws AWTException, InterruptedException {
        Robot robot = new Robot();
        Scanner scanner = new Scanner(System.in);
        System.out.print("程序想要运行多长时间, 单位秒(输入完毕按压回车): ");
        int time = scanner.nextInt();
        System.out.println("五秒后开始点击");
        Thread.sleep(1000);
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "秒");
            robot.delay(1000);
        }
        int count = time * 100;
        for (int i = 0; i < count; i++) {
            System.out.println("第" + i + "次点击!");
            robot.delay(100);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
        }
    }
}
