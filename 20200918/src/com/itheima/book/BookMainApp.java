package com.itheima.book;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import com.itheima.date.DatePicker;

public class BookMainApp extends JFrame {

	private JPanel contentPane;//中央面板
	private JTextField txtTitle;//书名的文本框
	private JTextField txtAuthor;//作者的文本框
	private JTextField txtPublishing;//出版社的文本框
	private JTextField txtPrice;//售价的文本框
	private ObservingTextField txtPublicationDate;//日期选择文本框
	private JTable table;
	private JPopupMenu jPopupMenu;//表格的右键菜单
	
	private int currentId;//记录当前修改数据的id值。

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookMainApp frame = new BookMainApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookMainApp() {
		setTitle("图书管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 954, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("图书信息管理系统");
		label.setForeground(Color.CYAN);
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		label.setBounds(399, 29, 159, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("书名：");
		label_1.setForeground(Color.YELLOW);
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_1.setBounds(46, 86, 57, 24);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("作者：");
		label_2.setForeground(Color.YELLOW);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_2.setBounds(347, 88, 57, 24);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("出版社：");
		label_3.setForeground(Color.YELLOW);
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_3.setBounds(609, 91, 70, 24);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("售价：");
		label_4.setForeground(Color.YELLOW);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_4.setBounds(46, 146, 57, 24);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("出版时间：");
		label_5.setForeground(Color.YELLOW);
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 15));
		label_5.setBounds(322, 146, 75, 24);
		contentPane.add(label_5);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(94, 89, 137, 21);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);
	
		
		txtAuthor = new JTextField();
		txtAuthor.setColumns(10);
		txtAuthor.setBounds(398, 90, 137, 21);
		contentPane.add(txtAuthor);
		
		txtPublishing = new JTextField();
		txtPublishing.setColumns(10);
		txtPublishing.setBounds(675, 89, 193, 21);
		contentPane.add(txtPublishing);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(94, 149, 137, 21);
		contentPane.add(txtPrice);
		
		txtPublicationDate = new ObservingTextField();
		txtPublicationDate.setBounds(398, 149, 137, 21);
		contentPane.add(txtPublicationDate);
		txtPublicationDate.setColumns(10);
		txtPublicationDate.setEnabled(false);
		txtPublicationDate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// instantiate the DatePicker
                DatePicker dp = new DatePicker(txtPublicationDate, Locale.CHINA);
                // previously selected date
                Date selectedDate = dp.parseDate(txtPublicationDate.getText());
                dp.setSelectedDate(selectedDate);
                dp.start(txtPublicationDate);
				
			
		}
		});
		
		JButton btnCancel = new JButton("取消");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//清空文本框
				clearTextField();
				
				//还原currentId
				currentId = 0;
				
				
				
			}
		});
		btnCancel.setBounds(609, 162, 98, 23);
		contentPane.add(btnCancel);
		
		JButton btnOK = new JButton("添加");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.获取文本框数据
				String title = txtTitle.getText().trim();
				String author = txtAuthor.getText().trim();
				String publishing = txtPublishing.getText().trim();
				String price = txtPrice.getText().trim();
				String publicationDate = txtPublicationDate.getText().trim();
					
				
				//2.进行一些验证
				if(title.length() == 0){
					//弹出一个对话框
					JOptionPane.showMessageDialog(null, "请填写书名！");
					//让书名的文本框获取焦点
					txtTitle.requestFocus();
					//结束方法
					return;
				}
				if(author.length() == 0){
					//弹出一个对话框
					JOptionPane.showMessageDialog(null, "请填写作者！");
					//让作者的文本框获取焦点
					txtAuthor.requestFocus();
					//结束方法
					return;
				}
				if(publishing.length() == 0){
					//弹出一个对话框
					JOptionPane.showMessageDialog(null, "请填写出版社！");
					//让出版社的文本框获取焦点
					txtPublishing.requestFocus();
					//结束方法
					return;
				}
				String regex = "\\d+\\.?\\d+";
				if(!price.matches(regex)){
					//弹出一个对话框
					JOptionPane.showMessageDialog(null, "售价填写不正确！");
					//让售价的文本框获取焦点
					txtPrice.requestFocus();
					//结束方法
					return;
				}
				if(publicationDate.length() == 0){
					//弹出一个对话框
					JOptionPane.showMessageDialog(null, "请填写出版日期！");
					
					//结束方法
					return;
				}
				if(btnOK.getText().equals("添加")){//执行添加
					//1.封装一个Book对象
					Book book = new Book();
					book.setTitle(title);
					book.setAuthor(author);
					book.setPublishing(publishing);
					book.setPrice(Double.parseDouble(price));
					book.setPublicationDate(publicationDate);
					
					//2.从文件中读取所有的Book信息
					List<Book> list = BookDAO.readAll();
					
					int id = 0;
					if(list != null && list.size() > 0){//文件中有数据
						//取出最后一条
						Book b2 = list.get(list.size() - 1);
						//取出id值
						id = b2.getId();
					}
					
					book.setId(id + 1);
					
					//3.将book对象存储到集合
					list.add(book);
					
					//4.将list覆盖写回文件
					BookDAO.writeAll(list);
					
					//5.刷新表格
					refreshTable();
					
					//6.提示
					JOptionPane.showMessageDialog(null, "数据添加成功！！");
					
					//7.清空文本框
					clearTextField();
					return;
					
					
				}else if(btnOK.getText().equals("修改")){//执行修改
					//1.从文件读取所有内容
					List<Book> books = BookDAO.readAll();
					//2.遍历找到修改的这条数据
					for(int i = 0; i < books.size() ; i++){
						if(currentId == books.get(i).getId()){
							Book book = books.get(i);
							//设置新的值
							book.setTitle(title);
							book.setAuthor(author);
							book.setPublishing(publishing);
							book.setPrice(Double.parseDouble(price));
							book.setPublicationDate(publicationDate);
							
							//4.将list覆盖写回文件
							BookDAO.writeAll(books);
							
							//5.刷新表格
							refreshTable();
							
							//6.清空文本框
							clearTextField();
							
							//7.提示
							JOptionPane.showMessageDialog(null, "数据修改成功！");
							
							//8.将按钮还原为添加
							btnOK.setText("添加");
							
						}
					}
				}
			}

			

			
		});
		btnOK.setBounds(770, 162, 98, 23);
		contentPane.add(btnOK);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblNewLabel.setBounds(23, 71, 899, 136);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 230, 899, 281);
		contentPane.add(scrollPane);
		
		table = new JTable(){//制作了一个JTable子类-作用：禁止数据被修改。
			@Override
			public boolean isCellEditable(int row, int column) {
			
				return false;
			}
		};
		table.setRowHeight(30);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"序号", "书名", "作者", "出版社", "售价", "出版日期"
			}
		));
		
		//初始化右键菜单
		jPopupMenu = new JPopupMenu();
		
		//修改菜单
		JMenuItem updateItem = new JMenuItem("          修改        ");
		updateItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//读取文件所有数据
				List<Book> books = BookDAO.readAll();
				
				//获取表格中选中的行
				int selectedRow = table.getSelectedRow();
				
				//遍历集合
				for(int i = 0; i < books.size() ; i++){
					if(i == selectedRow){
						//在文本框回显
						Book book = books.get(i);
						//回显
						txtTitle.setText(book.getTitle());
						txtAuthor.setText(book.getAuthor());
						txtPublishing.setText(book.getPublishing());
						txtPrice.setText(String.valueOf(book.getPrice()));
						txtPublicationDate.setText(book.getPublicationDate());
						//记录id
						currentId = book.getId();
						
						//将添加按钮的文本改为"修改"
						btnOK.setText("修改");
						
						return;
						
					}
				}
			}
		});
		
		//删除菜单
		JMenuItem deleteItem = new JMenuItem("          删除        ");
		deleteItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//1.从文件读取所有数据
				List<Book> books = BookDAO.readAll();
				
				//2.获取表格中选择的行的索引
				int selectedRow = table.getSelectedRow();
				
				//3.遍历集合
				for(int i = 0; i < books.size() ; i++){
					if(i == selectedRow){
						//确认删除
						int op = JOptionPane.showConfirmDialog(null, "您确定要删除这条数据吗？");
						if(op == 0){//确定
							books.remove(i);//从集合中删除
							//4.写回到文件
							BookDAO.writeAll(books);
							
							//5.刷新表格
							refreshTable();
							
							//6.提示
							JOptionPane.showMessageDialog(null, "数据已被删除！！");
							break;
						}
					}
				}
				
				
				
				return;
			}
		});
		
		//将两个item添加到Menu
		jPopupMenu.add(updateItem);
		jPopupMenu.addSeparator();//添加一个分割线
		jPopupMenu.add(deleteItem);
		
		//为表格添加鼠标事件
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//判断是右键
				if(e.getButton() == MouseEvent.BUTTON3){
					//通过点击位置找到点击为表格中的行
					int focusedRowIndex = table.rowAtPoint(e.getPoint());
					if(focusedRowIndex == -1){
						return;
					}
					//将表格所选项设为当前右键点击的行
					table.setRowSelectionInterval(focusedRowIndex, focusedRowIndex);
					//弹出菜单
					jPopupMenu.show(table,e.getX(),e.getY());
				}
			}
		});
		
		//设置表格列高度
		scrollPane.setViewportView(table);
		//初始化数据(来自于文件)
		refreshTable();
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(BookMainApp.class.getResource("/img/b3.jpg")));
		lblNewLabel_1.setBounds(0, 0, 948, 557);
		contentPane.add(lblNewLabel_1);
		//设置窗体居中
		this.setLocationRelativeTo(null);
		//设置禁止更改窗体大小
		this.setResizable(false);
		
	}
	
	//清空文本框
	private void clearTextField() {
		txtTitle.setText("");
		txtAuthor.setText("");
		txtPublishing.setText("");
		txtPrice.setText("");
		txtPublicationDate.setText("");
		
		//书名的文本框获取焦点
		txtTitle.requestFocus();
		
	}
	
	//刷新表格
	private  void refreshTable() {
		//1.创建数据行的二维数组
		List<Book> books = BookDAO.readAll();
		
		Object[][] objects = new Object[books.size()][6];
		for(int i = 0 ; i < books.size() ; i++){
			Book book = books.get(i);
			objects[i][0] = book.getId();
			objects[i][1] = book.getTitle();
			objects[i][2] = book.getAuthor();
			objects[i][3] = book.getPublishing();
			objects[i][4] = book.getPrice();
			objects[i][5] = book.getPublicationDate();
		}
		
		//2.列的一位数组
		String[] colArr = new String[] {
				"序号", "书名", "作者", "出版社", "售价", "出版日期"
			};
		
		//3.创建一个TableModel
		DefaultTableModel model = new DefaultTableModel(objects,colArr);
		
		//4.为table设置新的Model
		table.setModel(model);
		
	}
	
	class ObservingTextField extends JTextField implements Observer {
	    public void update(Observable o, Object arg) {
	        Calendar calendar = (Calendar) arg;
	        DatePicker dp = (DatePicker) o;
	        setText(dp.formatDate(calendar,"yyyy-MM-dd"));
	    }
	}
}
