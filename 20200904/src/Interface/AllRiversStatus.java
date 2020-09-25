package Interface;

import deal.CheckBoxShows;
import deal.SettingColorDeal;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:44
 */
public class AllRiversStatus extends JFrame {

    private JPanel panel;
    public JCheckBox locationCheck;
    public JCheckBox statusCheck;
    public JCheckBox lengthCheck;
    public JPanel answerPanel;

    public JLabel[] labels;
    public JLabel[] answers;

    public AllRiversStatus() {
        this.setSize(550, 500);
        this.setTitle("河流情况总览");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        initAnswer();
        init();
        this.setResizable(false);
        this.setVisible(true);
        //JOptionPane.showMessageDialog(this, "还没想好实现什么功能");
    }

    private void initAnswer() {
        answerPanel = new JPanel();
        answerPanel.setSize(250, 300);
        answerPanel.setLocation(170, 80);
        if (SettingColorDeal.theme != null) {
            answerPanel.setBackground(SettingColorDeal.theme);
        }
        answerPanel.setLayout(new GridLayout(6, 2, 0, 10));
        labels = new JLabel[6];
        answers = new JLabel[6];
        for (int i = 0; i < 6; i++) {
            labels[i] = new JLabel("");
            labels[i].setFont(new Font("", 1, 15));
            answers[i] = new JLabel("");
            answers[i].setFont(new Font("", 1, 15));
            answerPanel.add(labels[i]);
            answerPanel.add(answers[i]);
        }
        this.add(answerPanel);

    }

    private void init() {

        panel = new JPanel();
        panel.setSize(350, 30);
        panel.setLocation(100, 10);
        if (SettingColorDeal.theme != null) {
            panel.setBackground(SettingColorDeal.theme);
        }

        CheckBoxShows deal = new CheckBoxShows(this);

        panel.setLayout(new GridLayout(1, 3, 0, 10));

        locationCheck = new JCheckBox("分布情况");
        locationCheck.setFont(new Font("", 1, 20));
        if (SettingColorDeal.theme != null) {
            locationCheck.setBackground(SettingColorDeal.theme);
        }
        locationCheck.addActionListener(deal);
        panel.add(locationCheck);

        statusCheck = new JCheckBox("治理情况");
        statusCheck.setFont(new Font("", 1, 20));
        if (SettingColorDeal.theme != null) {
            statusCheck.setBackground(SettingColorDeal.theme);
        }
        statusCheck.addActionListener(deal);
        panel.add(statusCheck);

        lengthCheck = new JCheckBox("长度占比");
        lengthCheck.setFont(new Font("", 1, 20));
        if (SettingColorDeal.theme != null) {
            lengthCheck.setBackground(SettingColorDeal.theme);
        }
        lengthCheck.addActionListener(deal);
        panel.add(lengthCheck);

        this.add(panel);



    }
}
