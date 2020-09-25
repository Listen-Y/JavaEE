package deal;

import Interface.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * 主界面事件处理
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:30
 */
public class MainInterfaceDeal implements ActionListener {

    private RiverManagement event;

    public MainInterfaceDeal(RiverManagement event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String text = button.getText();
      /*  String[] names = new String[] {"显示所有河流", "查找具体河流", "增加河流信息",
                "修改河流信息", "删除具体河流", "河流整治总览"};*/

        switch (text.trim()) {
            case "显示所有河流":
                new ShowAllRivers();
                break;
            case "查找匹配河流":
                new FindRiver();
                break;
            case "增加河流信息":
                new AddRiver();
                break;
            case "修改河流信息":
                new UpdateRiver();
                break;
            case "删除具体河流":
                new DeleteRiver();
                break;
            case "河流情况总览":
                new AllRiversStatus();
                break;
        }

    }
}
