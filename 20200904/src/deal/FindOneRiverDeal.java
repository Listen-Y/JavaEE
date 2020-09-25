package deal;

import Interface.FindRiver;
import dao.RiverDao;
import exception.riverException;
import jdk.nashorn.internal.scripts.JO;
import model.River;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 17:25
 */
public class FindOneRiverDeal implements ActionListener {

    private FindRiver event;

    public FindOneRiverDeal(FindRiver event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = event.nameText.getText();
        if (name == null || name.trim().equals("")) {
            JOptionPane.showMessageDialog(event, "请填写名字");
            return;
        }

        //获取所有河流信息
        RiverDao dao = new RiverDao();
        //从数据库中获取信息
        List<River> rivers = null;
        try {
            rivers = dao.selectByNameList(event.nameText.getText());
        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "数据库错误");
            return;
        }

        //设置表格标题 和表格信息
        String[] titles = new String[] {"河流编号", "河流名称", "河流长度", "地理位置", "河流类型", "治理情况"};
        String[][] values = new String[rivers.size()][6];

        for (int i = 0; i < rivers.size(); i++) {
            River river = rivers.get(i);
            values[i][0] = String.valueOf(river.getRiver_num());
            values[i][1] = river.getRiver_name();
            values[i][2] = river.getRiver_length() + " (Km)";
            values[i][3] = river.getRiver_location();
            values[i][4] = river.getRiver_class();
            values[i][5] = river.getRiver_status();
        }
        //初始化表格和滚动面板
        event.table = new JTable(values, titles);
        event.table.getTableHeader().setFont(new Font("标楷体",Font.BOLD,16));
        event.table.setFont(new Font("",0,16));
        event.pane = new JScrollPane(event.table);
        event.pane.setSize(900, 400);
        event.pane.setLocation(50, 100);
        //总是出现垂直滚动条
        event.pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        event.add(event.pane);


    }
}
