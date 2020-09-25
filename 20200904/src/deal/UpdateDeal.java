package deal;

import Interface.UpdateRiver;
import dao.RiverDao;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 17:08
 */
public class UpdateDeal implements ActionListener {

    private UpdateRiver event;


    public UpdateDeal(UpdateRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //检查编号是否存在这个河流
        River river = null;
        if ((river = checkHave()) != null) {
            //"河流名称", "河流长度(Km)", "地理位置", "河流类型", "治理情况"
            String newName = event.textFields[0].getText();
            String newLength = event.textFields[1].getText();
            String newLocation = event.textFields[2].getText();
            String newRiverClass = (String) event.classBox.getSelectedItem();
            String newStatus = (String) event.statusBox.getSelectedItem();

            if (allNull(newName, newLength, newLocation, newRiverClass, newStatus)) {
                JOptionPane.showMessageDialog(event, "都为空修改个锤锤");
                return;
            }

            if (confirm()) {
                return;
            }

            if (updateRiver(river, newName, newLength, newLocation, newRiverClass, newStatus)) {
                JOptionPane.showMessageDialog(event, "修改成功");
                //"河流名称", "河流长度(Km)", "地理位置", "河流类型", "治理情况"
                event.textFields[0].setText("");
                event.textFields[1].setText("");
                event.textFields[2].setText("");
                event.classBox.setSelectedIndex(0);
                event.statusBox.setSelectedIndex(0);
                return;
            }
            JOptionPane.showMessageDialog(event, "修改失败");
        }


    }

    private boolean allNull(String newName, String newLength, String newLocation,
                            String newRiverClass, String newStatus) {

        return (newLength == null || newLength.trim().equals(""))
                && (newLocation == null || newLocation.trim().equals(""))
                && (newRiverClass == null || newRiverClass.trim().equals(""))
                && (newStatus == null || newStatus.trim().equals(""))
                && (newName == null || newName.trim().equals(""));
    }

    private boolean updateRiver(River river, String newName, String newLength, String newLocation,
                             String newRiverClass, String newStatus) {
        String name = river.getRiver_name();
        RiverDao dao = new RiverDao();

        try {

            if (newLength != null && !newLength.trim().equals("")) {

                if (checkLength(newLength)) {
                    JOptionPane.showMessageDialog(event, "注意长度的格式");
                    return false;
                }

                    dao.updateRiverLengthByName(name, newLength.trim());
            }

            if (newLocation != null && !newLocation.trim().equals("")) {
                dao.updateRiverLocationByName(name, newLocation);
            }

            if (newRiverClass != null && !newRiverClass.trim().equals("")) {
                dao.updateRiverClassByName(name, newRiverClass);
            }

            if (newStatus != null && !newStatus.trim().equals("")) {
                dao.updateRiverStatusByName(name, newStatus);
            }

            if (newName != null && !newName.trim().equals("")) {
                dao.updateRiverNewNameByName(name, newName);
            }
        } catch (riverException e) {
            JOptionPane.showMessageDialog(event, e.getMessage());
            return false;
        }
        return true;
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

    private River checkHave() {

        String num = event.numText.getText();
        if (num == null || num.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请输入河流编号");
            return null;
        }
        RiverDao dao = new RiverDao();
        River river = null;
        try {
            river = dao.selectByNum(Integer.parseInt(num.trim()));
            if (river == null) {
                JOptionPane.showMessageDialog(event, "请检查编号是否正确");
                return null;
            }
        } catch (riverException e) {
            JOptionPane.showMessageDialog(event, "数据错误");
            return null;
        }
        return river;
    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认修改?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }
}
