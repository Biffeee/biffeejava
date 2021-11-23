package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.sql.*;

import net.proteanit.sql.DbUtils;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
public class searchbtn extends JFrame {

	private JPanel contentPane;
	private JTextField txtsearch;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	
Connection conn=null;
	
	public PreparedStatement pst;
	public static ResultSet rs=null;
	public Statement st;
	private JTable table;
	private JLabel lblX;
	
	private void LoadData() {
		JavaConnect2SQL javaconnect2sql = new JavaConnect2SQL();
		javaconnect2sql.connect();
		try {
			rs=javaconnect2sql.GetData("QLSV_TTSV");
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
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, ""+e);
		}								
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchbtn frame = new searchbtn();
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
	public searchbtn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 150, 650, 400);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 79, 608, 288);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		txtsearch = new JTextField();
		txtsearch.setBounds(242, 48, 189, 20);
		txtsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
				String user="sa";
				String password="280500";
				try {
					String selection=(String)comboBox.getSelectedItem();
					Connection conn = DriverManager.getConnection(jdbcURL,user,password);										
					DefaultTableModel model= new DefaultTableModel();
					String query="select *from QLSV_TTSV where "+selection+"=?";
					PreparedStatement pst=conn.prepareStatement(query);
					
					pst.setString(1, txtsearch.getText().toLowerCase());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					pst.close();
					
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(txtsearch);
		txtsearch.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setBounds(69, 46, 145, 22);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"mssv", "name"}));
		contentPane.add(comboBox);
		
		lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát","Thông Báo",JOptionPane.YES_NO_OPTION)==0) {
					searchbtn.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblX.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblX.setForeground(Color.WHITE);
			}
		});
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblX.setBounds(606, 11, 20, 20);
		contentPane.add(lblX);
	
		LoadData();
		
	}
}
