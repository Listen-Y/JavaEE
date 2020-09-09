import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-10
 * Time: 9:53
 */
public class RobotImageDemo {
    //设置连续截屏次数
    private static int count = 100;
    //设置每次截屏的间隔时间
    private static int time = 100;

    public static void main(String[] args) throws AWTException, IOException {
        Robot robot = new Robot();
        //设置三面后开始截图
        System.out.println("三秒后开始截图");
        robot.delay(3000);
        //先要获取屏幕大小或者也可以自动设置截图的大小
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        for (int i = 0; i < count; i++) {
            //截取图片获取图片缓冲流
            BufferedImage bufferedImage = robot.createScreenCapture(new Rectangle(0, 0, size.width, size.height));
            //设置文件的保存路径+保存时文件的名字格式 文件名字就以保存的i命名这样多次截图图片名字也不会重复
            String url = "D:\\user\\testDate\\"
                    + i + ".jpg";
            //获得文件对象
            File file = new File(url);
            //将文件输出到指定的文件目录中
            ImageIO.write(bufferedImage, "jpg", file);
            if (i % 5 == 0) {
                System.out.println("进行中...");
            }
            //让截图有间隔
            robot.delay(time);
        }
        System.out.println("截图完成!!!");

    }
}
