package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.e;

/**
 * JDBC API를 이용한 RDBMS(Oracle11g) 연동
 * PreparedStatement 활용
 * @author 김기정
 */
public class DQLExample {
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String password = "hr";
	
	
	public static void findAll() throws ClassNotFoundException, SQLException {
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT employee_id, last_name, salary,  TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date")
          .append(" FROM employees");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			// 컬럼 인덱스로 컬럼값 접근 (비권장)
			/*
			while(rs.next()) {
				int employeeId = rs.getInt(1);
				String lastName = rs.getString(2);
				int salary = rs.getInt(3);
				String hireDate = rs.getString(4);
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate);
			}
			*/
			// 컬럼이름으로 접근 (권장)
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
	}
	
	
	public static List<Employee> findAll2() throws ClassNotFoundException, SQLException {
		List<Employee> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT employee_id, last_name, salary,  TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date")
          .append(" FROM employees");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			list = new ArrayList<Employee>();
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				Employee employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	// 사원번호를 입력받아 사원정보 반환
	public static Employee findById(int employeeId) throws ClassNotFoundException, SQLException {
		Employee employee = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT employee_id, first_name, last_name, salary,  TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date")
          .append(" FROM employees")
          .append(" WHERE employee_id = ?");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int empId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				
				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return employee;
	}
	
	// 이름(fist_name, last_name)으로 사원 검색
	public static List<Employee> findByName(String name) throws ClassNotFoundException, SQLException {
		List<Employee> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT employee_id, first_name, last_name, salary,  TO_CHAR(hire_date, 'YYYY-MM-DD HH24:MI:SS DAY') hire_date") 
          .append(" FROM employees")
          .append(" WHERE first_name LIKE '%' || ? || '%' OR last_name LIKE '%' || ? || '%'");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			list = new ArrayList<Employee>();
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				Employee employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	
	// 조인으로 사원번호, 사원이름, 부서명, 도시명 조회
	public static List<Map<String, Object>> findEmployeeDetail() throws ClassNotFoundException, SQLException {
		List<Map<String, Object>> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT") 
          .append("    e.employee_id,")
          .append("    e.last_name,")
          .append("    d.department_name,")
          .append("    l.city")
          .append(" FROM")
          .append("         employees e")
          .append(" JOIN departments d ON e.department_id = d.department_id")
          .append("   JOIN locations   l ON d.location_id = l.location_id");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, password);
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Map<String, Object>>();
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				String departmentName = rs.getString("department_name");
				String city = rs.getString("city");
				Map<String, Object> row = new HashMap<String, Object>();
				row.put("employee_id", employeeId);
				row.put("last_name", lastName);
				row.put("department_name", departmentName);
				row.put("city", city);
				list.add(row);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//findAll();
//		List<Employee> allList = findAll2();
//		for (Employee employee : allList) {
//			System.out.println(employee);			
//		}
		
//		Employee findEmp = findById(1007);
//		if(findEmp != null) {
//			System.out.println(findEmp.toString());
//		}else {
//			System.out.println("해당 사원이 존재하지 않습니다..");
//		}
		
//		List<Employee> findList = findByName("기정");
//		if(findList.isEmpty()) {
//			System.out.println("검색된 사원이 존재하지 않습니다..");
//			
//		}else {
//			for (Employee employee : findList) {
//				System.out.println(employee);			
//			}
//		}
		
		List<Map<String, Object>> list = findEmployeeDetail();
		for (Map<String, Object> row : list) {
//			System.out.println(row);
			int id = (Integer)row.get("employee_id");
			String ename = (String)row.get("last_name");
			String dname = (String)row.get("department_name");
			String city = (String)row.get("city");
			System.out.println(id + ", " + ename + ", " + dname + ", " + city);
		}
		
	}
}






