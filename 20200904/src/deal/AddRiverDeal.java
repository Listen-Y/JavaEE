package deal;

import Interface.AddRiver;
import dao.RiverDao;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 16:30
 */
public class AddRiverDeal implements ActionListener {

    private AddRiver event;

    public AddRiverDeal(AddRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String name = event.textFields[0].getText();
        if (name.equals("李星亚")) {
            JOptionPane.showMessageDialog(event, "增尼巴呢???");
            event.textFields[0].setText("");
            return;
        }

        String length = event.textFields[1].getText();
        if (checkLength(length)) {
            JOptionPane.showMessageDialog(event, "注意长度的格式");
            //将面板内容清空
            for (int i = 0; i < 3; i++) {
                event.textFields[i].setText("");
            }
            return;
        }

        String location = event.textFields[2].getText();
        //判断信息是否未填写
        if (check(name, length, location)) {
            String riverClass = (String) event.classBox.getSelectedItem();
            String status = (String) event.statusBox.getSelectedItem();
            River river = new River();
            river.setRiver_class(riverClass);
            river.setRiver_length(length.trim());
            river.setRiver_location(location.trim());
            river.setRiver_name(name.trim());
            river.setRiver_status(status);
            //数据库处理
            RiverDao dao = new RiverDao();
            try {
                dao.addRiver(river);
            } catch (riverException ex) {
                JOptionPane.showMessageDialog(event, "增加失败,检查所填写河流是否已经存在");
                //将面板内容清空
                for (int i = 0; i < 3; i++) {
                    event.textFields[i].setText("");
                }
                return;
            }
            //将面板内容清空
            for (int i = 0; i < 3; i++) {
                event.textFields[i].setText("");
            }
            JOptionPane.showMessageDialog(event, "增加成功");
        } else {
            JOptionPane.showMessageDialog(event, "请完整填写信息!");
        }

    }

    private boolean checkLength(String length) {

        if (length == null || length.trim().equals("")) {
            return false;
        }
        //判断是不是汉字
        if (length.getBytes().length != length.length()) {
            return true;
        }
        //判断是不是数字
        try {
            Integer.parseInt(length);
        } catch (NumberFormatException e) {
            return true;
        }
        //判断是否小于等于0
        return Integer.parseInt(length) <= 0;
    }

    private boolean check(String name, String length, String location) {
        return name != null && !name.trim().equals("") && length != null && !length.trim().equals("") && location != null && !location.trim().equals("");
    }
}
