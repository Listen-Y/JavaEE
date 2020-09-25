package Interface;

import dao.RiverDao;
import deal.FindOneRiverDeal;
import deal.OnlyDealFindRiver;
import deal.SettingColorDeal;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:39
 */
public class FindRiver extends JFrame {

    private JLabel message;
    //编号
    private JLabel name;
    public JTextField nameText;
    private JButton ok;

    //使用表格和滚动面板实现河流信息的展示
    public JTable table;
    public JScrollPane pane;


    public FindRiver() {

        this.setSize(1000, 600);
        this.setTitle("显示所有河流信息");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        //获取所有河流信息
        RiverDao dao = new RiverDao();
        init();
    }

    private void init() {

        message = new JLabel();
        message.setSize(400, 30);
        message.setLocation(0, 0);
        message.setText("根据名称查找信息");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        name = new JLabel("河流名称");
        name.setSize(100, 30);
        name.setLocation(0, 50);
        name.setFont(new Font("", 1, 20));
        nameText = new JTextField();
        nameText.setSize(100, 40);
        nameText.setLocation(110, 50);
        nameText.setFont(new Font("", 0, 20));
        ok = new JButton("查找");
        ok.setFont(new Font("", 1, 15));
        ok.setSize(100, 30);
        ok.setLocation(250, 50);
        FindOneRiverDeal deal = new FindOneRiverDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
        this.add(name);
        this.add(nameText);

    }




/*    private void init(List<River> lists) {
        message = new JLabel();
        message.setSize(400, 30);
        message.setLocation(0, 0);
        message.setText("根据名称查找信息");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        name = new JLabel("河流名称");
        name.setSize(100, 30);
        name.setLocation(0, 50);
        name.setFont(new Font("", 1, 20));
        nameText = new JTextField();
        nameText.setSize(100, 40);
        nameText.setLocation(110, 50);
        nameText.setFont(new Font("", 0, 20));
        ok = new JButton("查找");
        ok.setFont(new Font("", 1, 15));
        ok.setSize(100, 30);
        ok.setLocation(250, 50);
        FindOneRiverDeal deal = new FindOneRiverDeal(this);
        ok.addActionListener(deal);
        this.add(ok);
        this.add(name);
        this.add(nameText);

        //初始化标签
        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(100, 140);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        String[] names = new String[] {"河流名称:", "河流长度(Km):", "地理位置:", "河流类型:", "治理情况:"};
        labels = new JLabel[6];
        answers = new JLabel[6];
        for (int i = 0; i < names.length; i++) {
            labels[i] = new JLabel(names[i]);
            labels[i].setFont(new Font("", 1, 23));
            answers[i] = new JLabel();
            answers[i].setFont(new Font("", 0, 15));
            panel.add(labels[i]);
            panel.add(answers[i]);
        }
        this.add(panel);
    }*/
}
