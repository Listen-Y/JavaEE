package deal;

import Interface.RiverManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-06
 * Time: 10:34
 */
public class SettingColorDeal implements ActionListener {

    public static Color theme = null;

    private RiverManagement event;

    public SettingColorDeal(RiverManagement event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton abstractButton = (AbstractButton) e.getSource();

        //"白色" 蓝色", "青色", "灰色", "绿色", "浅灰", "紫色","橘色", "粉色", "红色", "黄色"
        Map<String, Color> choose = makeChoose();
        theme = choose.get(abstractButton.getText());
        //event.container.setBackground(theme);
        event.panel.setBackground(theme);
        event.getContentPane().setBackground(choose.get(abstractButton.getText()));

    }

    private Map<String, Color> makeChoose() {

        Map<String, Color> choose = new HashMap<>();
        choose.put("白色", Color.white);
        choose.put("蓝色", Color.BLUE);
        choose.put("青色", Color.CYAN);
        choose.put("灰色", Color.GRAY);
        choose.put("绿色", Color.GREEN);
        choose.put("浅灰", Color.LIGHT_GRAY);
        choose.put("紫色", Color.MAGENTA);
        choose.put("橘色", Color.ORANGE);
        choose.put("粉色", Color.PINK);
        choose.put("红色", Color.RED);
        choose.put("黄色", Color.YELLOW);
        return choose;
    }
}
