import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-08
 * Time: 17:24
 */
public class JPopupMenuDemo extends JFrame implements MouseListener {

    //弹出式菜单
    private JPopupMenu popupMenu;
    //菜单
    private JMenu[] menus;
    //菜单项
    public JMenuItem[] items1;
    public JMenuItem[] items2;

    public JPopupMenuDemo() {
        this.setSize(400, 500);
        this.setLayout(null);
        init();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void init() {

        //初始化菜单
        String[] menuNames = new String[] {"操作" ,"设置"};
        menus = new JMenu[menuNames.length];
        for (int i = 0; i < menuNames.length; i++) {
            menus[i] = new JMenu(menuNames[i]);
        }
        popupMenu = new JPopupMenu();
        //初始化第一个菜单里的菜单项
        String[] names = new String[] {"复制", "剪切", "粘贴", "删除"};
        items1 = new JMenuItem[names.length];
        for (int i = 0; i < names.length; i++) {
            items1[i] = new JMenuItem(names[i]);
            menus[0].add(items1[i]);
        }
        //注册第一个菜单
        popupMenu.add(menus[0]);
        //初始化第二个菜单的菜单项
        String[] menuNames2 = new String[] {"放大", "缩小"};
        items2 = new JMenuItem[menuNames2.length];
        for (int i = 0; i < menuNames2.length; i++) {
            items2[i] = new JMenuItem(menuNames2[i]);
            menus[1].add(items2[i]);
        }
        //注册
        popupMenu.add(menus[1]);
        //下面注册鼠标事件处理更不能忘
        popupMenu.addMouseListener(this);
        this.addMouseListener(this);


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        //当释放鼠标的时候打开弹出式菜单
        System.out.println("释放一次鼠标");
        //判断是否为弹出式窗口触发
        if (e.isPopupTrigger()) {
            popupMenu.show(this, e.getX(), e.getY());
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
