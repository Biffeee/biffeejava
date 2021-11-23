package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;



import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.sql.*;
import java.text.MessageFormat;
import java.util.Vector;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import javax.swing.ImageIcon; 

public class testapp extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmssv;
	private JTextField txtname;
	private JTextField txtphone;
	private JTextField txtkhoa;
	private JTextField txtemail;
	private JTextField txtlop;
	private JTextField txtaddress;
	private JTextField txttoan;
	private JTextField txtanh;
	private JTextField txtvan;
	private JTextField txtdiemtb;
	private JTable table;

	Connection conn=null;
	
	public PreparedStatement pst;
	public static ResultSet rs=null;
	public Statement st;
	
	private void LoadData() {
		JavaConnect2SQL javaconnect2sql = new JavaConnect2SQL();
		javaconnect2sql.connect();
		try {
			rs=javaconnect2sql.GetData("QLSV_TTSV");
			table.removeAll();
			String[] arr= {"id","mssv","name","phone","email","lop","address","khoa","gioitinh","toan","van","anh","diemtb"};
			DefaultTableModel model= new DefaultTableModel(arr,0);
			while(rs.next()) {
				Vector<String> vec=new Vector<String>();
				vec.add(rs.getString("id"));
				vec.add(rs.getString("mssv"));
				vec.add(rs.getString("name"));
				vec.add(rs.getString("phone"));
				vec.add(rs.getString("email"));
				vec.add(rs.getString("lop"));
				vec.add(rs.getString("address"));
				vec.add(rs.getString("khoa"));
				vec.add(rs.getString("gioitinh"));
				vec.add(rs.getString("toan"));
				vec.add(rs.getString("van"));
				vec.add(rs.getString("anh"));
				vec.add(rs.getString("diemtb"));
				model.addRow(vec);
			}
			table.setModel(model);
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, ""+e);
		}								
	}
			
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testapp frame = new testapp();
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
	public testapp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1300, 739);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MSSV");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHTn = new JLabel("Họ Tên");
		lblHTn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHTn.setBounds(10, 60, 92, 14);
		contentPane.add(lblHTn);
		
		JLabel lblSt = new JLabel("SĐT");
		lblSt.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSt.setBounds(10, 116, 92, 14);
		contentPane.add(lblSt);
		
		JLabel lblKhoa = new JLabel("Khoa");
		lblKhoa.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblKhoa.setBounds(10, 172, 92, 14);
		contentPane.add(lblKhoa);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(304, 172, 92, 14);
		contentPane.add(lblEmail);
		
		JLabel lblLp = new JLabel("Lớp");
		lblLp.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLp.setBounds(304, 116, 92, 14);
		contentPane.add(lblLp);
		
		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblaCh.setBounds(304, 11, 74, 14);
		contentPane.add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGiiTnh.setBounds(304, 60, 74, 14);
		contentPane.add(lblGiiTnh);
		
		JLabel lblTon = new JLabel("Toán");
		lblTon.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTon.setBounds(606, 13, 74, 14);
		contentPane.add(lblTon);
		
		JLabel lblVn = new JLabel("Văn");
		lblVn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblVn.setBounds(606, 116, 74, 14);
		contentPane.add(lblVn);
		
		JLabel lblAnh = new JLabel("Anh");
		lblAnh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAnh.setBounds(606, 60, 74, 14);
		contentPane.add(lblAnh);
		
		JLabel lblimTb = new JLabel("Điểm TB");
		lblimTb.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblimTb.setBounds(606, 172, 74, 14);
		contentPane.add(lblimTb);
		
		txtmssv = new JTextField();
		txtmssv.setColumns(10);
		txtmssv.setBounds(10, 29, 206, 20);
		contentPane.add(txtmssv);
		
		txtname = new JTextField();
		txtname.setColumns(10);
		txtname.setBounds(10, 85, 206, 20);
		contentPane.add(txtname);
		
		txtphone = new JTextField();
		txtphone.setColumns(10);
		txtphone.setBounds(10, 141, 206, 20);
		contentPane.add(txtphone);
		
		txtkhoa = new JTextField();
		txtkhoa.setColumns(10);
		txtkhoa.setBounds(10, 197, 206, 20);
		contentPane.add(txtkhoa);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(304, 197, 206, 20);
		contentPane.add(txtemail);
		
		txtlop = new JTextField();
		txtlop.setColumns(10);
		txtlop.setBounds(304, 141, 206, 20);
		contentPane.add(txtlop);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(304, 29, 206, 20);
		contentPane.add(txtaddress);
		
		JComboBox cbbgioitinh = new JComboBox();
		cbbgioitinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ ", "Khác"}));
		cbbgioitinh.setBounds(304, 85, 206, 22);
		contentPane.add(cbbgioitinh);
		
		txttoan = new JTextField();
		txttoan.setColumns(10);
		txttoan.setBounds(606, 29, 96, 20);
		contentPane.add(txttoan);
		
		txtanh = new JTextField();
		txtanh.setColumns(10);
		txtanh.setBounds(606, 85, 96, 20);
		contentPane.add(txtanh);
		
		txtvan = new JTextField();
		txtvan.setColumns(10);
		txtvan.setBounds(606, 141, 96, 20);
		contentPane.add(txtvan);
		
		txtdiemtb = new JTextField();
		txtdiemtb.setColumns(10);
		txtdiemtb.setBounds(606, 197, 96, 20);
		contentPane.add(txtdiemtb);
		
		JScrollPane scrollPane = new JScrollPane();		
		scrollPane.setBounds(0, 388, 1283, 312);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectedIndex=table.getSelectedRow();
				String mssv = table.getValueAt(table.getSelectedRow(), 1).toString();
				String name = table.getValueAt(table.getSelectedRow(), 2).toString();
				String phone = table.getValueAt(table.getSelectedRow(), 3).toString();
				String email = table.getValueAt(table.getSelectedRow(), 4).toString();
				String lop = table.getValueAt(table.getSelectedRow(), 5).toString();
				String address = table.getValueAt(table.getSelectedRow(), 6).toString();
				String khoa = table.getValueAt(table.getSelectedRow(), 7).toString();
				//String gioitinh = table.getValueAt(table.getSelectedRow(), 8).toString();
				cbbgioitinh.setSelectedItem(model.getValueAt(selectedIndex, 8).toString());
				String toan = table.getValueAt(table.getSelectedRow(), 9).toString();
				String van = table.getValueAt(table.getSelectedRow(), 10).toString();
				String anh = table.getValueAt(table.getSelectedRow(), 11).toString();
				String diemtb = table.getValueAt(table.getSelectedRow(), 12).toString();
		        txtmssv.setText(mssv);
		        txtname.setText(name);
		        txtphone.setText(phone);
		        txtemail.setText(email);
		        txtlop.setText(lop);
		        txtaddress.setText(address);
		        txtkhoa.setText(khoa);
		        //cbbgioitinh.setSelectedItem(gioitinh);
		        txttoan.setText(toan);
		        txtvan.setText(van);
		        txtanh.setText(anh);
		        txtdiemtb.setText(diemtb);
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnthem = new JButton("THÊM");
		btnthem.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\add-icon.png"));
		btnthem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnthem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
				String user="sa";
				String password="280500";
				double[] R = new double[13];
				R[0]=Double.parseDouble(txttoan.getText());
				R[1]=Double.parseDouble(txtvan.getText());
				R[2]=Double.parseDouble(txtanh.getText());
				
				R[3] =(R[0]+R[1]+R[2])/3;
				String diemtb= String.format("%.0f",R[3]);
				txtdiemtb.setText(diemtb);
				
				String sql="INSERT INTO QLSV_TTSV(mssv,name,phone,email,lop,address,khoa,gioitinh,toan,van,anh,diemtb)VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
				try
				{
					Connection conn = DriverManager.getConnection(jdbcURL,user,password);					
					pst=conn.prepareStatement(sql);
					pst.setString(1,txtmssv.getText());
					pst.setString(2,txtname.getText());
					pst.setString(3,txtphone.getText());
					pst.setString(4,txtemail.getText());
					pst.setString(5,txtlop.getText());
					pst.setString(6,txtaddress.getText());
					pst.setString(7,txtkhoa.getText());
					pst.setString(8,(String)cbbgioitinh.getSelectedItem());
					pst.setString(9,txttoan.getText());
					pst.setString(10,txtvan.getText());
					pst.setString(11,txtanh.getText());
					pst.setString(12,txtdiemtb.getText());
					
					pst.executeUpdate();				
					rs.close();
					pst.close();		
					JOptionPane.showMessageDialog(null,"System Update Completed","Student Database",JOptionPane.OK_OPTION);
					
				}
				
				catch(Exception ev)
				{
					JOptionPane.showMessageDialog(null,"System fail","Student Database",JOptionPane.OK_OPTION);
					
				}
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				model.addRow(new Object[] {
						txtmssv.getText(),
						txtname.getText(),
						txtphone.getText(),
						txtemail.getText(),
						txtlop.getText(),
						txtaddress.getText(),
						txtkhoa.getText(),
						cbbgioitinh.getSelectedItem(),
						txttoan.getText(),
						txtvan.getText(),
						txtanh.getText(),
						txtdiemtb.getText(),
				});
				
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"Update confirmed","Student Database",JOptionPane.OK_OPTION );
					}
				}				
			
			}											
		});
		btnthem.setBounds(357, 256, 146, 38);
		contentPane.add(btnthem);
		
		JButton btnsua = new JButton("SỬA");
		btnsua.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\Editing-Edit-icon.png"));
		btnsua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnsua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
				String user="sa";
				String password="280500";
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				int id=Integer.parseInt(model.getValueAt(selectIndex,0).toString());
				double[] R = new double[13];
				R[0]=Double.parseDouble(txttoan.getText());
				R[1]=Double.parseDouble(txtvan.getText());
				R[2]=Double.parseDouble(txtanh.getText());
				
				R[3] =(R[0]+R[1]+R[2])/3;
				
				
				String mssv=txtmssv.getText();
				String name=txtname.getText();
				String phone=txtphone.getText();
				String email=txtemail.getText();
				String lop=txtlop.getText();
				String address=txtaddress.getText();
				String khoa=txtkhoa.getText();
				String gioitinh=cbbgioitinh.getSelectedItem().toString();
				String toan=txttoan.getText();
				String van=txtvan.getText();
				String anh=txtanh.getText();
				String diemtb= String.format("%.0f",R[3]);
				txtdiemtb.setText(diemtb);
				try {
					Connection conn = DriverManager.getConnection(jdbcURL,user,password);										
					String query="Update QLSV_TTSV set mssv=?,name=?,phone=?,email=?,lop=?,address=?,khoa=?,gioitinh=?,toan=?,van=?,anh=?,diemtb=? where id=? ";
					PreparedStatement pst=conn.prepareStatement(query);
					pst.setString(1,mssv);
					pst.setString(2,name);
					pst.setString(3,phone);
					pst.setString(4,email);
					pst.setString(5,lop);
					pst.setString(6,address);
					pst.setString(7,khoa);
					pst.setString(8,gioitinh);
					pst.setString(9,toan);
					pst.setString(10,van);
					pst.setString(11,anh);
					pst.setString(12,diemtb);
					pst.setInt(13,id);
					pst.executeUpdate();
					LoadData();					
					pst.close();
					rs.close();
					JOptionPane.showMessageDialog(null, "Update Sucess");
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				
			}
		});
		btnsua.setBounds(513, 256, 146, 38);
		contentPane.add(btnsua);
		
		JButton btnxoa = new JButton("XÓA");
		btnxoa.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\Editing-Delete-icon.png"));
		btnxoa.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnxoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
				String user="sa";
				String password="280500";
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectIndex = table.getSelectedRow();
				try {
					int id=Integer.parseInt(model.getValueAt(selectIndex,0).toString());
					int dialogResult=JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa?","Warning",JOptionPane.YES_NO_OPTION);
															
					String query="Delete QLSV_TTSV where id=? ";
										
					if(dialogResult==JOptionPane.YES_NO_OPTION)
					{
						Connection conn = DriverManager.getConnection(jdbcURL,user,password);
						PreparedStatement pst=conn.prepareStatement(query);
						pst.setInt(1, id);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Delete Success");
						LoadData();
					}									
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		btnxoa.setBounds(669, 256, 146, 38);
		contentPane.add(btnxoa);
		
		JButton btnexit = new JButton("EXIT");
		btnexit.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\delete-icon.png"));
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmtestapp = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmtestapp,"Confirm if you want to exit","Login",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					//System.exit(0);
					formmenu menu=new formmenu();
					menu.setVisible(true);
					testapp.this.dispose();
					
				}
			}
		});
		btnexit.setBounds(669, 320, 146, 38);
		contentPane.add(btnexit);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		panel.setBounds(856, 11, 403, 359);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea txtarea = new JTextArea();
		txtarea.setBackground(Color.WHITE);
		txtarea.setBounds(10, 11, 383, 337);
		panel.add(txtarea);
		
		JButton btnbangdiem = new JButton("BẢNG ĐIỂM");
		btnbangdiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtarea.setText("");
				txtarea.append("Student Result Recording Systen\n"
						+"=============================================\n"
						+"MSSV:\t\t"+txtmssv.getText()
						+"\nHọ Tên:\t\t"+txtname.getText()
						+"\nSĐT:\t\t"+txtphone.getText()
						+"\nEmail:\t\t"+txtemail.getText()
						+"\nLớp:\t\t"+txtlop.getText()
						+"\nĐịa Chỉ:\t\t"+txtaddress.getText()
						+"\nKhoa:\t\t"+txtkhoa.getText()
						+"\nGiới Tính:\t\t"+cbbgioitinh.getSelectedItem()
						+"\n=============================================\n"
						+"\nToán:\t\t"+txttoan.getText()
						+"\nĐVăn:\t\t"+txtvan.getText()
						+"\nĐAnh:\t\t"+txtanh.getText()
						+"\nĐiểm TB:\t\t"+txtdiemtb.getText()+"\n");
			}
		});
		btnbangdiem.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\Paper-icon.png"));
		btnbangdiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnbangdiem.setBounds(357, 320, 146, 38);
		contentPane.add(btnbangdiem);
		
		JButton btnprint = new JButton("PRINT");
		btnprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header=new MessageFormat("Printing in progress");
				MessageFormat footer=new MessageFormat("Page {0,number,integer}");
				
				try
				{
					txtarea.print();
				}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("No Printer found",ev.getMessage());
				}
			}
		});
		btnprint.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\printer-icon.png"));
		btnprint.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnprint.setBounds(513, 320, 146, 38);
		contentPane.add(btnprint);
		
		JButton btnrefresh = new JButton("REFRESH");
		btnrefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField temp=null;
				for(Component c:contentPane.getComponents()) {
					if(c.getClass().toString().contains("javax.swing.JTextField")) {
					temp=(JTextField)c;
					temp.setText(null);
					}
					
				}
				cbbgioitinh.setSelectedIndex(0);
				txtarea.setText(null);
			}
		});
		btnrefresh.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\refresh-icon.png"));
		btnrefresh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnrefresh.setBounds(201, 320, 146, 38);
		contentPane.add(btnrefresh);
		
		
		LoadData();
	}
}
