package deal;

import Interface.FindRiver;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-08
 * Time: 19:43
 */
public class OnlyDealFindRiver implements ActionListener, MouseListener {

    private FindRiver event;

    public OnlyDealFindRiver(FindRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        /*JMenuItem item = (JMenuItem) e.getSource();
        if (item.getText().equals("清空")) {
            for (JLabel label : event.answers
                 ) {
                if (label != null) {
                    label.setText("");
                }
            }
        } else {
            JOptionPane.showMessageDialog(event, "清空失败");
        }*/
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        /*if (e.isPopupTrigger()) {
            event.popupMenu.show(event, e.getX(), e.getY());
        }
*/
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
