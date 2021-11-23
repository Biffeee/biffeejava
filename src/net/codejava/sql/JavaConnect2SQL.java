package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import javax.swing.JOptionPane;

public class JavaConnect2SQL {
	
	private Connection conn;
	private String jdbcURL="jdbc:sqlserver://localhost:1433;databaseName=QLSV";
	String user="sa";
	String password="280500";
	PreparedStatement pst = null;
	
	public void connect() {			
		try {						
			conn = DriverManager.getConnection(jdbcURL,user,password);
			JOptionPane.showMessageDialog(null, "Kết nối thành công");
			
		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null, ""+e);
			e.printStackTrace();
		}
	}
	
	public ResultSet GetData(String jtable) throws SQLException {
		ResultSet kq= null;		
		Statement st=conn.createStatement();						
		String sql="SELECT *FROM QLSV_TTSV";
		kq=st.executeQuery(sql);
		return kq;
	}
	
	
	public static void main(String[] args) {
		JavaConnect2SQL javaconnect2sql=new JavaConnect2SQL();
		javaconnect2sql.connect();
		
	}

	

}
