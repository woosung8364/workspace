package ezen.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class CallableStatementExample {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password = "hr";

	public static void procedureMethod(int employeeId) throws ClassNotFoundException, SQLException {
		
		String sql = "{call findemployeebyno(?, ?, ?, ?)}"; 
		
		Connection con = null;
		CallableStatement cstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			cstmt = con.prepareCall(sql);
			cstmt.setInt(1, employeeId);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.execute();
			int id = cstmt.getInt(2);
			String name = cstmt.getString(3);
			int salary = cstmt.getInt(4);
			System.out.println(id);
			System.out.println(name);
			System.out.println(salary);
		}finally {
			try {
				if(cstmt != null) cstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		
	}
	
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		procedureMethod(120);

	}

}
