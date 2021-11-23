package net.codejava.sql;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtpass;
	private JTextField txtuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 458, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("UserName");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(199, 28, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PassWord");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(199, 83, 79, 14);
		contentPane.add(lblNewLabel_2);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(199, 108, 235, 20);
		contentPane.add(txtpass);
		
		txtuser = new JTextField();
		txtuser.setColumns(10);
		txtuser.setBounds(199, 52, 235, 20);
		contentPane.add(txtuser);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass=txtpass.getText();
				String user=txtuser.getText();
				if(pass.contains("admin")&&user.contains("admin")) {
					txtpass.setText(null);
					txtuser.setText(null);
					formmenu menu=new formmenu();
					formmenu.main(null);
					
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtpass.setText(null);
					txtuser.setText(null);
				}
			}
		});
		btnLogin.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\Login-in-icon.png"));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(199, 153, 106, 42);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frmloginapp = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frmloginapp,"Confirm if you want to exit","Login",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\delete-icon.png"));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(328, 153, 106, 42);
		contentPane.add(btnExit);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(199, 139, 235, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\thanh\\Downloads\\Student-Male-icon.png"));
		lblNewLabel_3.setBounds(30, 52, 159, 137);
		contentPane.add(lblNewLabel_3);
	}

}
