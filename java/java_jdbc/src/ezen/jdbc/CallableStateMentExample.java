package ezen.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 * 
 * @author i7C-
 *
 */
public class CallableStateMentExample {

	
//	스태틱 지역변수 초기화
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String passwd = "hr";
	
	
//	사원번호값을 전달받아 사원정보 (부서 , 이름 , 임금) 조회하기
	public static void procedureMethod(int employeeId) throws ClassNotFoundException, SQLException {
		
		
		
		//변수 초기화부
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		
		String sql=("{call findemployeebyno(? , ?, ?, ?)}");
		StringBuilder sb = new StringBuilder();
	
		
		try {
//		드라이버 불러오기
		Class.forName(driver);
//		데이타베이스 연결하기
		con=DriverManager.getConnection(url,userid,passwd);
		
//		CallableStatement 클래스를 통하여 실행할 sql문 () 을 준비시킴
		cstmt = con.prepareCall(sql);
		
		
//		결과값을 출력받을 파라미터를 등록
		cstmt.setInt(1, employeeId);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.registerOutParameter(3, Types.VARCHAR);
		cstmt.registerOutParameter(4, Types.INTEGER);
		
//		CallableStatement 객체를 실행
		cstmt.execute();
		
		//결과값을 cmi로 돌려받기 () : 파라미터 순서
		int id =cstmt.getInt(2);
		String name = cstmt.getString(3);
		int salary = cstmt.getInt(4);
		System.out.println(id);
		System.out.println(name);
		System.out.println(salary);
		
		} finally {
			try {
				if(con != null) con.close();
				if(rs != null) rs.close();
				// preparestatement 객체가 생성되어있다면
				if(cstmt != null) cstmt.close();
			} catch (Exception e) {
				
			}
			
		}
		
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		procedureMethod(120);
	}

}
