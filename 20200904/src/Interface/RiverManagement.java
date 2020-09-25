package Interface;

import deal.MainInterfaceDeal;
import deal.SettingColorDeal;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 主界面
 * User: Listen-Y.
 * Date: 2020-09-04
 * Time: 23:39
 */
@SuppressWarnings("all")
public class RiverManagement extends JFrame {

    //设置窗体颜色的菜单
    public JMenuBar bar; //菜单栏
    public JMenu menu; //菜单
    public JMenuItem[] items; //菜单项

    //标签
    private JLabel label;
    //实现6个功能按钮
    private JButton[] jButtons;
    //放按钮的面板
    public JPanel panel;
    //容器
    public Container container;

    public RiverManagement() {
        this.setSize(800, 600);
        this.setTitle("河流信息管理");
        this.setLayout(null);
        //初始化菜单
        initMenu();
        //初始化其他控件
        init();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
    }

    private void initMenu() {
        menu = new JMenu("设置窗体颜色");
        menu.setFont(new Font("", 1, 20));
        String[] colors = new String[] {"白色", "蓝色", "青色", "灰色", "绿色", "浅灰", "紫色","橘色", "粉色", "红色", "黄色"};
        items = new JMenuItem[colors.length];
        SettingColorDeal deal = new SettingColorDeal(this);
        for (int i = 0; i < colors.length; i++) {
            items[i] = new JMenuItem(colors[i]);
            items[i].addActionListener(deal);
            menu.add(items[i]);
        }
        bar = new JMenuBar();
        bar.add(menu);
        this.setJMenuBar(bar);
    }

    //添加控件
    private void init() {
        System.out.println(111);
        //添加标签
        label = new JLabel();
        label.setText("欢迎您来到 214么么哒 河流管理主界面");
        label.setFont(new Font("", 1, 30));
        label.setSize(600, 100);
        label.setLocation(140, 80);
        //this.add(label);
        //添加按钮
        panel = new JPanel();
        panel.setSize(400, 220);
        panel.setLocation(200, 230);
        panel.setLayout(new GridLayout(3, 2, 20, 40));
        jButtons = new JButton[6];
        String[] names = new String[] {"显示所有河流", "查找匹配河流", "增加河流信息",
                                      "修改河流信息", "删除具体河流", "河流情况总览"};
        //添加按钮 注册事件
        MainInterfaceDeal deal = new MainInterfaceDeal(this);
        for (int i = 0; i < jButtons.length; i++) {
            jButtons[i] = new JButton(names[i]);
            jButtons[i].setFont(new Font("", Font.PLAIN, 20));
            //注册监听器
            jButtons[i].addActionListener(deal);
            panel.add(jButtons[i]);
        }
        //this.add(panel);
        container = this.getContentPane();
        container.add(label);
        container.add(panel);

    }
}
