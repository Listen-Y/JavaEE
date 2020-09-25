package deal;

import Interface.DeleteRiver;
import dao.RiverDao;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import static javax.swing.JOptionPane.YES_NO_CANCEL_OPTION;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 16:47
 */
public class DeleteDeal implements ActionListener{

    private DeleteRiver event;

    public DeleteDeal(DeleteRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //获取删除的名字
        String name = event.text.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写完整信息");
            return;
        }
        RiverDao dao = new RiverDao();

        try {
            River river = dao.selectByName(name.trim());
            if (river == null) {
                JOptionPane.showMessageDialog(event, "请检查是这条河是否存在");
                return;
            }
        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "数据库错误");
            return;
        }


        if (confirm()) {
            return;
        }

        try {
            dao.deleteRiverByName(name.trim());
        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "删除失败");
            return;
        }
        event.text.setText("");
        JOptionPane.showMessageDialog(event, "删除成功");
    }

    private boolean confirm() {
        int ret = JOptionPane.showConfirmDialog(event, "确认删除?","警告", YES_NO_CANCEL_OPTION);
        return ret != JOptionPane.YES_OPTION;
    }
}
