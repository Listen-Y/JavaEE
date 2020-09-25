package Interface;


import deal.SettingColorDeal;
import deal.UpdateDeal;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:42
 */
@SuppressWarnings("all")
public class UpdateRiver extends JFrame {

    private JLabel message;
    //编号
    private JLabel num;
    public JTextField numText;


    public JPanel panel;
    //nameLabel, lengthLabel, locationLabel, classLabel, statusLabel
    public JLabel[] labels;
    //nameField, lengthField, locationField
    public JTextField[] textFields;
    public JComboBox classBox, statusBox;
    private JButton ok;


    public UpdateRiver() {
        this.setSize(500, 700);
        this.setTitle("修改河流信息");
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

        message = new JLabel();
        message.setSize(400, 30);
        message.setLocation(0, 0);
        message.setText("编号不可修改, 只可根据编号修改其他内容");
        message.setFont(new Font("", 0, 20));
        this.add(message);
        num = new JLabel("河流编号");
        num.setSize(100, 30);
        num.setLocation(0, 50);
        num.setFont(new Font("", 1, 20));
        numText = new JTextField();
        numText.setSize(60, 30);
        numText.setLocation(110, 50);
        numText.setFont(new Font("", 0, 20));
        this.add(num);
        this.add(numText);

        panel = new JPanel();
        panel.setSize(350, 340);
        panel.setLocation(85, 140);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        //初始化comboBox
        // 河道类型：这与河道建造所处的地形有关，分为平原区河道、山区河道、丘陵区河道、沿海区河道和内陆河道
        classBox = new JComboBox();
        classBox.addItem("");
        classBox.addItem("内陆河道");
        classBox.addItem("平原区河道");
        classBox.addItem("山区河道");
        classBox.addItem("丘陵区河道");
        classBox.addItem("沿海区河道");
        classBox.setFont(new Font("", 1, 20));
        // 河道整治情况有 优 良 差
        statusBox = new JComboBox();
        statusBox.addItem("");
        statusBox.addItem("优");
        statusBox.addItem("良");
        statusBox.addItem("差");
        statusBox.setFont(new Font("", 1, 20));
        //初始化其他
        String[] labelNames = new String[] {"河流名称", "河流长度(Km)", "地理位置", "河流类型", "治理情况"};
        labels = new JLabel[5];
        textFields = new JTextField[3];
        int indexText = 0;
        for (int i = 0; i < labelNames.length; i++) {
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setFont(new Font("", 1, 20));
            panel.add(labels[i]);
            if (i == 3 || i == 4) {
                if (i == 3) {
                    panel.add(classBox);
                } else {
                    panel.add(statusBox);
                }
            } else {
                textFields[indexText] = new JTextField();
                textFields[indexText].setFont(new Font("", 0, 20));
                panel.add(textFields[indexText]);
                indexText++;
            }
        }
        this.add(panel);
        ok = new JButton("确认");
        ok.setSize(100, 60);
        ok.setLocation(200, 500);
        ok.setFont(new Font("", 1, 30));
        UpdateDeal deal = new UpdateDeal(this);
        ok.addActionListener(deal);
        this.add(ok);

    }
}
