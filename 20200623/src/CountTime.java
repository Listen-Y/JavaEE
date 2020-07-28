import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountTime extends JFrame implements ActionListener {

    private JLabel timeLable;
    private JButton beg;
    private JButton end;
    private boolean key = true;

    public CountTime(){
        this.setSize(420,350);
        this.setTitle("计时器");
        this.setLayout(null);
        init();
        //关闭窗口就结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //大小不可变
        this.setResizable(false);
        //可见
        this.setVisible(true);

    }

    private void init() {
        timeLable = new JLabel("0");
        timeLable.setFont(new Font("", Font.BOLD, 90));
        timeLable.setSize(200,90);
        timeLable.setLocation(175,50);
        this.add(timeLable);

        beg = new JButton("开始计时");
        beg.setSize(100,60);
        beg.setLocation(90,180);
        beg.addActionListener(this);
        this.add(beg);

        end = new JButton("结束计时");
        end.setSize(100,60);
        end.setLocation(210,180);
        end.setEnabled(false);
        end.addActionListener(this);
        this.add(end);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        Thread t = new Thread() {
            @Override
            public void run() {
                countTime();
            }
        };

        if (button.getText().equals("开始计时")) {
            end.setEnabled(true);
            beg.setEnabled(false);
            key = true;
            timeLable.setLocation(175,50);
            timeLable.setText("0");
            t.start();
        } else {
            key = false;
            end.setEnabled(false);
            beg.setEnabled(true);
        }
     }

    private void countTime() {
        int count = 0;
        boolean move = true;
        while (key) {
            try {
                Thread.sleep(1000);
                count++;

                if (count >= 10 && move) {
                    this.timeLable.setLocation(145, 50);
                    move = false;
                }

                if (key) {
                    this.timeLable.setText(String.valueOf(count));
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        CountTime countTime = new CountTime();
    }
}

