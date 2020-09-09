/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 实现在画图板上画出奥运五环
 * User: Listen-Y.
 * Date: 2020-08-08
 * Time: 8:49
 */

import java.awt.*;
import java.awt.event.InputEvent;

public class RobotDemo {
    public static void main(String[] args) throws AWTException {
        Robot robot = new Robot();
        //等待5秒 5秒后必须打开画图板选中椭圆才可正常运行
        robot.delay(5000);

        //第一个圆
        int i = 10;
        while (i-- > 0) {
            robot.mouseMove(400, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(650, 550);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000);       //画完一个圆停止0.2s，否则因为计算机执行速度太快，看不到动态作图的过程

        //第二个圆
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(0, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK); //画完一个圆后在圆外面点一下鼠标，否则回拖动画的圆到下一个位置
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(600, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);       //这里延迟0.1s，可以看到动态画的过程
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(850, 550);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(1000);       //画完一个圆停止0.2s，否则因为计算机执行速度太快，看不到动态作图的过程

        //第三个圆
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(0, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK); //画完一个圆后在圆外面点一下鼠标，否则回拖动画的圆到下一个位置
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(800, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);       //这里延迟0.2s，可以看到动态画的过程
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(1050, 550);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);       //画完一个圆停止0.1s，否则因为计算机执行速度太快，看不到动态作图的过程

        //第四个圆
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(0, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK); //画完一个圆后在圆外面点一下鼠标，否则回拖动画的圆到下一个位置
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(500, 425);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);       //这里延迟0.1s，可以看到动态画的过程
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(750, 675);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);       //画完一个圆停止0.2s，否则因为计算机执行速度太快，看不到动态作图的过程

        //第五个圆
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(0, 300);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK); //画完一个圆后在圆外面点一下鼠标，否则回拖动画的圆到下一个位置
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(700, 425);
        }
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.delay(100);       //这里延迟0.1s，可以看到动态画的过程
        i = 10;
        while (i-- > 0) {
            robot.mouseMove(950, 675);
        }
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(200);       //画完一个圆停止0.2s，否则因为计算机执行速度太快，看不到动态作图的过程


    }
}
