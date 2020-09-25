package Interface;

import deal.DeleteDeal;
import deal.SettingColorDeal;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 删除河流
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:43
 */
public class DeleteRiver extends JFrame {

    private JPanel panel;
    public JLabel name;
    public JTextField text;
    public JButton ok;

    public DeleteRiver() {
        this.setSize(500, 400);
        this.setTitle("删除河流");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        init();
    }

    private void init() {
        //初始化面板
        panel = new JPanel();
        panel.setSize(300, 50);
        panel.setLocation(100, 50);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(1, 2, 0, 10));
        //初始化控件
        name = new JLabel("河流名称");
        name.setFont(new Font("", 1, 30));
        text = new JTextField();
        text.setFont(new Font("", 0, 20));
        panel.add(name);
        panel.add(text);
        this.add(panel);
        ok = new JButton("删除");
        ok.setSize(100, 60);
        ok.setLocation(250, 150);
        ok.setFont(new Font("", 1, 30));
        DeleteDeal deleteDeal = new DeleteDeal(this);
        ok.addActionListener(deleteDeal);
        this.add(ok);

    }
}
