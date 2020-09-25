package Interface;

import dao.RiverDao;
import deal.OnlyDealFindRiver;
import deal.SettingColorDeal;
import deal.ShowAllRiverMouseDeal;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-05
 * Time: 11:38
 */
public class ShowAllRivers extends JFrame {
    //使用表格和滚动面板实现河流信息的展示
    public JTable table;
    private JScrollPane pane;

    //弹出式菜单
    public JPopupMenu popupMenu;
    //弹出式菜单里的菜单项
    private JMenuItem[] items;

    public ShowAllRivers() {

        this.setSize(1000, 500);
        this.setTitle("显示所有河流信息");
        this.setLayout(null);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null); //点击一个关闭所有并退出程序
        if (SettingColorDeal.theme != null) {
            this.getContentPane().setBackground(SettingColorDeal.theme);
        }
        this.setResizable(false);
        this.setVisible(true);
        //获取所有河流信息
        RiverDao dao = new RiverDao();
        try {
            //从数据库中获取信息
            List<River> rivers = dao.SelectAll();
            init(rivers);
            initMenu();
        } catch (riverException e) {
            JOptionPane.showMessageDialog(this, "获取信息异常!");
        }
    }

    private void initMenu() {

        popupMenu = new JPopupMenu();
        String[] titles = new String[] {"删除", "修改"};
        ShowAllRiverMouseDeal deal = new ShowAllRiverMouseDeal(this);
        items = new JMenuItem[2];
        for (int i = 0; i < titles.length; i++) {
            items[i] = new JMenuItem(titles[i]);
            items[i].addActionListener(deal);
            popupMenu.add(items[i]);
        }
        pane.addMouseListener(deal);
        popupMenu.addMouseListener(deal);
        table.addMouseListener(deal);
        this.addMouseListener(deal);

    }

    private void init(List<River> rivers) {
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
        table = new JTable(values, titles);
        table.getTableHeader().setFont(new Font("标楷体",Font.BOLD,16));
        table.setFont(new Font("",0,16));
        pane = new JScrollPane(table);
        pane.setSize(900, 400);
        pane.setLocation(50, 50);
        //总是出现垂直滚动条
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane);


    }
}
