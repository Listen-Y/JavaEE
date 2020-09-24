/**
 * GUI
 */
import java.awt.*;
import javax.swing.*;
//创建一个登陆窗口
//继承框架窗口类
public class GUITest extends JFrame  {

    //定义窗口中的控件
    JLabel userLabel, pwLabel;//定义标签 用户名标签 密码标签
    JTextField userText;//输入用户名的文本框
    JPasswordField pwText;//输入密码的文本框
    JButton loginBt, quiBt;//定义俩个按钮 一个登陆 一个 退出


    public GUITest() {//在构造方法内设置窗体属性
        this.setSize(400, 300);//设置窗体的尺寸
        //this.setSize(new Dimension(400, 300));
        this.setTitle("登陆窗口");
        this.getContentPane().setBackground(Color.white);
        //点击x就可以直接关闭
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();//在构造方法内调用初始化控件方法
        this.setVisible(true);//设置窗口可见

    }
    //初始化登陆控件
    private void init() {
        userLabel = new JLabel("用户名");
        pwLabel = new JLabel();
        pwLabel.setText("密码");
        userText = new JTextField();//初始化文本框对象
        userText.setBackground(Color.gray);
        pwText = new JPasswordField();//初始化密码框对象
        pwText.setBackground(Color.gray);
        loginBt = new JButton("登陆");//初始化按钮
        quiBt = new JButton();
        quiBt.setText("退出");
        //窗口添加控件对象
        //默认的边界布局
        //this.add(userLabel, BorderLayout.NORTH);
        /*//流布局
        //创建一个流布局对象来设置登陆窗口的布局方式
        //从左到右从上到下布局 可以随大小变化
        this.setLayout(new FlowLayout());
        this.add(userLabel);
        this.add(pwLabel);
        this.add(userText);
        this.add(pwText);
        this.add(loginBt);
        this.add(quiBt);*/
        /*
        //网格布局
        this.setLayout(new GridLayout(3,2));
        //将当前改为网格布局 三行俩列
        this.add(userLabel);
        this.add(userText);
        this.add(pwLabel);
        this.add(pwText);
        this.add(loginBt);
        this.add(quiBt);*/
        //改为精确布局
        this.setLayout(null);//设置布局对象为空
        userLabel.setSize(60, 30);//设置控件大小
        //userLabel.setLocation(new Point(30,30));
        userLabel.setLocation(50,70);//设置控件左上角坐标
        this.add(userLabel);
        userText.setSize(210, 30);
        userText.setLocation(110, 70);
        this.add(userText);
        pwLabel.setSize(60, 30);
        pwLabel.setLocation(50, 120);
        this.add(pwLabel);
        pwText.setSize(210, 30);
        pwText.setLocation(110,120);
        this.add(pwText);
        loginBt.setSize(60,30);
        loginBt.setLocation(100,200);
        this.add(loginBt);
        quiBt.setSize(60,30);
        quiBt.setLocation(240, 200);
        this.add(quiBt);

    }
}