import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-08-10
 * Time: 16:14
 */
public class AutoLoadImage {

    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame();
        MyCanvas myCanvas = new MyCanvas();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //将图片按比例缩小倍展示
        jFrame.setSize(960, 540);
        jFrame.setVisible(true);

        loadImage(myCanvas, jFrame);
    }

    private static void loadImage(MyCanvas myCanvas, JFrame jFrame) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            Image image = Toolkit.getDefaultToolkit().getImage("D:\\user\\testDate\\" + i + ".jpg");
            myCanvas.setImage(image);
            jFrame.add(myCanvas);
            //设置连续加载图片间隔时间 会有闪白问题所有不会形成一个视频去播放 解决闪白问题需要使用双缓冲技术待我后续解决
            Thread.sleep(300);
        }
    }

}

class MyCanvas extends Canvas {
    private Image image;

    public void setImage(Image image) {
        this.image = image;
    }

    public void paint(Graphics graphics) {
        //设置成随图片大小变化而变化 不会造成图片缺少
        graphics.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
