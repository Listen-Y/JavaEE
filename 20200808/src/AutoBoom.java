import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 实现一个聊天轰炸器
 * User: Listen-Y.
 * Date: 2020-08-10
 * Time: 8:58
 */
public class AutoBoom {

    //设置轰炸的次数
    private static int count = 10;
    //设置每次循环的间隔时间
    private static int time = 1000;

    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        //使用这个程序必须先将轰炸的内容复制好然后打开聊天框
        //所以预留5秒做准备
        System.out.println("复制好内容打开聊天框五秒后进行轰炸");
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "秒");
            robot.delay(1000);
        }
        System.out.println("开始");
        for (int i = 0; i < count; i++) {
            //同时按下ctrl+v粘贴好 然后在同时释放ctrl+v
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            //让轰炸有间隔的进行
            robot.delay(time);
            //按下回车让信息发送
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
    }
}
