package deal;

import Interface.DeleteRiver;
import Interface.ShowAllRivers;
import Interface.UpdateRiver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-13
 * Time: 9:25
 */
public class ShowAllRiverMouseDeal implements MouseListener, ActionListener {

    private ShowAllRivers event;

    public ShowAllRiverMouseDeal(ShowAllRivers event) {
        this.event = event;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.isPopupTrigger()) {
            event.popupMenu.show(event, e.getX(), e.getY());
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //item事件处理
    @Override
    public void actionPerformed(ActionEvent e) {

        JMenuItem item = (JMenuItem) e.getSource();
        if (item.getText().equals("删除")) {
            int r = event.table.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(event, "请选择表格中数据");
                return;
            }
            Object name = event.table.getValueAt(r, 1);
            if (name == null) {
                JOptionPane.showMessageDialog(event, "数据错误");
                return;
            }
            DeleteRiver deleteRiver = new DeleteRiver();
            deleteRiver.text.setText(name.toString());
        } else {
            int r = event.table.getSelectedRow();
            if (r == -1) {
                JOptionPane.showMessageDialog(event, "请选择表格中数据");
                return;
            }
            Object num = event.table.getValueAt(r, 0);
            if (num == null) {
                JOptionPane.showMessageDialog(event, "数据错误");
                return;
            }
            UpdateRiver updateRiver = new UpdateRiver();
            updateRiver.numText.setText(num.toString());
            for (int i = 0; i < updateRiver.textFields.length; i++) {
                Object value = event.table.getValueAt(r, i + 1);
                updateRiver.textFields[i].setText(value.toString());
            }
            Object value = event.table.getValueAt(r, 4);
            updateRiver.classBox.setSelectedItem(value.toString());
            Object value1 = event.table.getValueAt(r, 5);
            updateRiver.statusBox.setSelectedItem(value1.toString());
        }

    }
}
