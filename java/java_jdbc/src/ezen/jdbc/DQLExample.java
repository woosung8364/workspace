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

/**
 * JDBC API를 이용한 RDBMS (ORACLE) 연동
 * @author i7C- 송우성
 * 연습용으로 throw 사용
 */
public class DQLExample {
		
	    int count = 0;
		//db 연동을 위한 변수 생성
		private static String driver = "oracle.jdbc.driver.OracleDriver";
		private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private static String userid = "hr";
		private static String passwd = "hr";
	
		public static List<Employee> findList() throws ClassNotFoundException, SQLException {
			
			//객체를 담기위한 클래스 생성
			List<Employee> list = null;
		
			//문자열을 효율적으로 추가하고 편집하기위한 StringBulider 클래스 생성
			StringBuilder sb = new StringBuilder();
			
//			hire_date처럼 함수를 쓴경우 반드시 별칭을 설정해줘야 한다
//			sql에 명령어를 보내기 위한 명령어 내용 설정
			sb.append("SELECT employee_id , last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")
			
//			sql 문을 보낼때 두번째 줄은 반드시 뛰워줘야한다
			.append(" FROM employees");
			
			//데이터베이스와의 연결을 설정하고 sql 문을 실행하기 위해 사용
			//statement 클래스 생성 커밋 , 롤백등의 기능
			Connection con = null;
			
			//java에서 sql 문을 실행하기 위한 클래스 
			//statement 클래스는 connection 으로 부터 생성
			PreparedStatement pstmt = null;
			
			//커서 역할 , 결과집합을 받기 위함
			ResultSet rs = null;
			
			
			//try - finally 예외가 발생하면 예외내용은 던져주되 리소스 처리는 본 클래스에서 진행되어야한다
			try {
			//드라이버 로딩
			//드라이버 이름으로한 클래스 인스턴스 생성
			Class.forName(driver);
			
//			DriverManger : jdbc 드라이버를 관리하고 데이터베이스에 연결하는 클래스
//			데이터 베이스에 연결하는 메소드
			con=DriverManager.getConnection(url,userid,passwd);
			
//			수동커밋이 가능하게 만들어주는 메소드
//			con.setAutoCommit(false);
			
			
			// SQL 문을 실행할 수 있는 prepareStatement 객체 생성
			// 매게변수를 무조건 문자열로 변환해서 받겠다
			pstmt=con.prepareStatement(sb.toString()); 
			
//			sql 코드 실행했을때 결과값들 = 커서
			rs= pstmt.executeQuery();
			
			//employee 추상 클래스를 만들어서 list 배열안에 객체들을 선언.
			list= new ArrayList<Employee>();
			
			
//			수동커밋을 설정했으니 수동으로 커밋설정 필요
//			con.commit();
			
			
			
			//컬럼이름으로 접근 (권장)
			//많은 객체들을 루프 돌리면서 list 배열에 초기화시켜주는 작업
			while(rs.next()) {
				int employeeId= rs.getInt("employee_id");
				String lastName=rs.getString("last_name");
				int salary=rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate); 
				Employee employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
			//값을 수정해보기
			// setString(?의 순서 , 값) 
			//바인딩변수에 매게변수를 대입함
//			pstmt.setString(1, departmentName);
			
			//생성된 statement 객채를 통해 insert 문을 실행
			// executeUpdate() : 수정된 행의 수를 반환
			int count= pstmt.executeUpdate();  
			
			} finally {
				try {
					//데이터베이스가 연결이 되어있다면
					if(con != null) con.close();
					if(rs != null) rs.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
				
			}
			return list;
		}
	
		
		//이름 (first_name , last_name) 으로 사원 검색
		public static List<Employee> findByName(String name) throws ClassNotFoundException, SQLException {
			
			List<Employee> list = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT employee_id , first_name, last_name , salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') hire_date")
			.append(" FROM employees")
			.append(" WHERE first_name LIKE '%' || ? || '%'  OR last_name LIKE '%' || ? || '%' ");
			
			try {
			Class.forName(driver);
			
			
			con=DriverManager.getConnection(url,userid,passwd);
			pstmt=con.prepareStatement(sb.toString()); 
			pstmt.setString(1, name);
			pstmt.setString(2, name);
			
			rs= pstmt.executeQuery();
			
			list= new ArrayList<Employee>();
			
			while(rs.next()) {
				//변수 선언& 초기화부
				int employeeId= rs.getInt("employee_id");
				String lastName=rs.getString("last_name");
				String firstName=rs.getString("first_name");
				int salary=rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate); 
				Employee employee = new Employee();
				
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
			
			int count= pstmt.executeUpdate();  
			
			} finally {
				try {
					if(con != null) con.close();
					if(rs != null) rs.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
				
			}
			return list;
		}
		
		
		
		
		
		
		//사원번호를 입력받아 사원정보를 변환
		public static Employee findById(int employeeId) throws ClassNotFoundException, SQLException {
			
			//지역변수 초기화 블록
			Employee employee = null;
			List<Employee> list = null;
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT employee_id ,first_name,last_name, salary , TO_CHAR(hire_date , 'YYYY-MM-DD HH24:MI:SS DAY') hire_date ")
			.append(" FROM employees")
			.append(" WHERE employee_id= ?");
			
			try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,userid,passwd);
			pstmt=con.prepareStatement(sb.toString()); 
			pstmt.setInt(1, employeeId);
			rs= pstmt.executeQuery();
			
			list= new ArrayList<Employee>();
			
			//컬럼이름으로 접근 (권장)
			//많은 객체들을 루프 돌리면서 list 배열에 초기화시켜주는 작업
			while(rs.next()) {
				int empId= rs.getInt("employee_id");
				String firstName=rs.getString("first_name");
				String lastName=rs.getString("last_name");
				int salary=rs.getInt("salary");
				String hireDate = rs.getString("hire_date");
				System.out.println(employeeId + "\t" + lastName + "\t" + salary + "\t" + hireDate); 
				employee = new Employee();
				employee.setEmployeeId(employeeId);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setSalary(salary);
				employee.setHireDate(hireDate);
				list.add(employee);
			}
			//값을 수정해보기
			// setString(?의 순서 , 값) 
			//바인딩변수에 매게변수를 대입함
//			pstmt.setString(1, departmentName);
			
			//생성된 statement 객채를 통해 insert 문을 실행
			// executeUpdate() : 수정된 행의 수를 반환
			int count= pstmt.executeUpdate();  
			
			} finally {
				try {
					//데이터베이스가 연결이 되어있다면
					if(con != null) con.close();
					if(rs != null) rs.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
				
			}
			return employee;
		}
		
	
	
				//조인으로 사원번호 , 사원이름 , 부서명 , 도시명 조회
				//조인을 맵 클래스의 키와 값을 이용하여 객체를 담음
	public static List<Map<String, Object>> findEmployeeDetail() throws ClassNotFoundException, SQLException {
					
					List<Map<String, Object>> list = null;
					Connection con = null;
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					
					StringBuilder sb = new StringBuilder();
					sb.append("SELECT")
					.append(" e.employee_id,")
					.append(" e.last_name,")
					.append(" d.department_name,")
					.append(" l.city")
					.append(" FROM")
					.append(" employees e")
					.append(" JOIN departments d ON e.department_id = d.department_id")
					.append(" JOIN locations   l ON d.location_id = l.location_id");
				
					
					try {
					Class.forName(driver);
					con=DriverManager.getConnection(url,userid,passwd);
					pstmt=con.prepareStatement(sb.toString()); 
					rs= pstmt.executeQuery();
					list= new ArrayList<Map<String, Object>>();
					
					while(rs.next()) {
						//변수 선언& 초기화부
						int employeeId= rs.getInt("employee_id");
						String lastName=rs.getString("last_name");
						String departmentName=rs.getString("department_name");
						String city=rs.getString("city");
						
						//HASHMAP 클래스를 이용한 값과 키 초기화
						Map<String, Object> row = new HashMap<String, Object>();
						row.put("employee_id", employeeId);
						row.put("last_name", lastName);
						row.put("department_name", departmentName);
						row.put("city", city);
						list.add(row); 
					}
					} finally {
						try {
							if(con != null) con.close();
							if(rs != null) rs.close();
							// preparestatement 객체가 생성되어있다면
							if(pstmt != null) pstmt.close();
						} catch (Exception e) {
							
						}
						
					}
					return list;
				}
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

//		Employee findEmp = findById(107);
//		if (findEmp !=null) {
//			System.out.println(findEmp.toString());
//		} else {
//			System.out.println("해당 사원이 존재하지 않습니다....");
//		}
		
		
//		List<Employee> findEmps = findByName("ab");
//		if (true) {
//			System.out.println("검색된 사원이 존재하지않습니다");
//		} else {
//			for (Employee employee : findEmps) {
//				System.out.println(employee);
//			}
//		}
		
		
		
		List<Map<String, Object>> list = findEmployeeDetail();
		for (Map<String, Object> row : list) {
			int id=(Integer)row.get("employee_id");
			String ename = (String)row.get("last_name");
			String dname = (String)row.get("department_name");
			String city = (String)row.get("city");
			System.out.println(id + ","+ ename  + "," + dname + "," + city);
		}
	
		}

	
	}

