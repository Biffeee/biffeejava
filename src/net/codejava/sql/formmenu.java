package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class formmenu extends JFrame {

	private JPanel panel;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formmenu frame = new formmenu();
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
	public formmenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1302, 717);
		setUndecorated(true);
		setLocationRelativeTo(null);
		panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		
		JPanel pntieude = new JPanel();
		pntieude.setBackground(new Color(60, 179, 113));
		pntieude.setBounds(185, 0, 1107, 94);
		panel.add(pntieude);
		pntieude.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		lblNewLabel.setForeground(new Color(230, 230, 250));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel.setBounds(381, 11, 302, 61);
		pntieude.add(lblNewLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát","Thông Báo",JOptionPane.YES_NO_OPTION)==0) {
					formmenu.this.dispose();
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
		lblX.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setBounds(1066, 0, 20, 20);
		pntieude.add(lblX);
		
		JPanel pnmenu = new JPanel();
		pnmenu.setBackground(new Color(47, 79, 79));
		pnmenu.setBounds(0, 0, 184, 717);
		panel.add(pnmenu);
		pnmenu.setLayout(null);
		
		JPanel pnttsv = new JPanel();
		pnttsv.addMouseListener(new PanelButtonMouseAdapter(pnttsv));
		pnttsv.setBackground(new Color(47, 79, 79));
		pnttsv.setBounds(0, 117, 184, 100);
		pnmenu.add(pnttsv);
		pnttsv.setLayout(null);
		pnttsv.addMouseListener(new MouseAdapter() {
			@Override
		public void mouseClicked(MouseEvent e) {
			testapp test=new testapp();
			test.setVisible(true);
		}
		});
		JLabel lblNewLabel_1 = new JLabel("TH\u00D4NG TIN SINH VI\u00CAN");
		
		lblNewLabel_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 184, 100);
		pnttsv.add(lblNewLabel_1);
		
		JPanel pntimkiem = new JPanel();
		pntimkiem.addMouseListener(new PanelButtonMouseAdapter(pntimkiem));
		pntimkiem.setBackground(new Color(47, 79, 79));
		pntimkiem.setBounds(0, 217, 184, 100);
		pnmenu.add(pntimkiem);
		pntimkiem.setLayout(null);
		pntimkiem.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			searchbtn search=new searchbtn();
			search.setVisible(true);
		}
		});
		JLabel lblNewLabel_2 = new JLabel("TÌM KIẾM");
		lblNewLabel_2.setForeground(new Color(230, 230, 250));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 184, 100);
		pntimkiem.add(lblNewLabel_2);
		
		
		JPanel pnbaocao = new JPanel();
		pnbaocao.addMouseListener(new PanelButtonMouseAdapter(pnbaocao));
		pnbaocao.setBackground(new Color(47, 79, 79));
		pnbaocao.setBounds(0, 316, 184, 100);
		pnmenu.add(pnbaocao);
		pnbaocao.setLayout(null);
		pnbaocao.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			try {
				String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
				String user="sa";
				String password="280500";
				String sql="SELECT *FROM QLSV_TTSV";
				JasperDesign jdesign=JRXmlLoader.load("D:\\Java2SqlServer1\\src\\net\\codejava\\sql\\Blank_A4.jrxml");
				Connection conn = DriverManager.getConnection(jdbcURL,user,password);
				JRDesignQuery updateQuery=new JRDesignQuery();
				updateQuery.setText(sql);
				jdesign.setQuery(updateQuery);
				JasperReport Jreport=JasperCompileManager.compileReport(jdesign);
				JasperPrint JasperPrint=JasperFillManager.fillReport(Jreport,null, conn);
				JasperViewer.viewReport(JasperPrint,false);
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, ex);
			}
						
		}
		});
		JLabel lblNewLabel_3 = new JLabel("B\u00C1O C\u00C1O");
		lblNewLabel_3.setForeground(new Color(230, 230, 250));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(0, 0, 184, 100);
		pnbaocao.add(lblNewLabel_3);
		
		JPanel pnlogout = new JPanel();
		pnlogout.addMouseListener(new PanelButtonMouseAdapter(pnlogout));
		pnlogout.setLayout(null);
		pnlogout.setBackground(new Color(47, 79, 79));
		pnlogout.setBounds(0, 415, 184, 100);
		pnmenu.add(pnlogout);
		pnlogout.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			
			if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?")==0) {
			login loginapp=new login();
			loginapp.setVisible(true);
			formmenu.this.dispose();
			}
		}
		});
		
		JLabel lblNewLabel_3_1 = new JLabel("LOG OUT");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(230, 230, 250));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(0, 0, 184, 100);
		pnlogout.add(lblNewLabel_3_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(185, 96, 1117, 621);
		panel.add(panel_1);
	}
	
	JLabel lblx=new JLabel("X");
	
	
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
			
	}
}
