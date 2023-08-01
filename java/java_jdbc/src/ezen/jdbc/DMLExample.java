package ezen.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC API를 이용한 RDBMS (ORACLE) 연동
 * @author i7C- 송우성
 * 연습용으로 throw 사용
 */
public class DMLExample {
		
	    int count = 0;
		//db 연동을 위한 변수 생성
		private static String driver = "oracle.jdbc.driver.OracleDriver";
		private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
		private static String userid = "hr";
		private static String passwd = "hr";
	
		public static int removeDepartment(String departmentName) throws ClassNotFoundException, SQLException {
			
		
			//sql 명령어를 보내기 위한 변수 생성
			// ? : 바인딩변수 : 값이 바뀔 수 있는 부분 
//			String sql = "INSERT INTO departments(department_id, department_name, manager_id ,location_id)" +
//						 "VALUES(departments.seq.NEXTVAL,?,?, ?)";
			
			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM departments")
//			sql 문을 보낼때 두번째 줄은 반드시 뛰워줘야한다
			.append(" WHERE department_name LIKE  '%' || ?  || '%' ");
			
			//statement : stream 역할 주고받고
			//데이터베이스와의 연결을 설정하고 sql 문을 실행하기 위해 사용
			//statement 클래스 생성 커밋 , 롤백등의 기능
			Connection con = null;
			
			//java에서 sql 문을 실행하기 위한 클래스 
			//statement 클래스는 connection 으로 부터 생성
			PreparedStatement pstmt = null;
			
			//try - finall 예외가 발생하면 예외내용은 던져주되 리소스는 확실하게 해제
			
			try {
			//드라이버 로딩
			Class cls =Class.forName(driver);
			
//			DriverManger : jdbc 드라이버를 관리하고 데이터베이스에 연결하는 클래스
//			데이터 베이스에 연결하는 메소드
			con=DriverManager.getConnection(url,userid,passwd);
			// SQL 문을 실행할 수 있는 prepareStatement 객체 생성
			pstmt=con.prepareStatement(sb.toString()); 
			
			
			//값을 수정해보기
			// setString(?의 순서 , 값) 
			//바인딩변수에 매게변수를 대입함
			pstmt.setString(1, departmentName);
			
			System.out.println(pstmt);
			//생성된 statement 객채를 통해 insert 문을 실행
			// executeUpdate() : 수정된 행의 수를 반환
			int count= pstmt.executeUpdate();  
			
			return count;
			} finally {
				try {
					//데이터베이스가 연결이 되어있다면
					if(con != null) con.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
				
			}
			
		}
	
	
		
		// 쿼리 두개를 활용하여 사원 급여 + 500 업데이트 해보기
		public static int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {
			
			//변수 초기화
			int count=0;
			Connection con = null;
			PreparedStatement pstmt = null;
			
			
			//쿼리 두개
			
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO employees(employee_id , first_name , last_name,email, phone_number , hire_date , job_id  , salary , department_id)")
			.append(" VALUES(employees_seq.NEXTVAL,?,?,? , ? , sysdate , ? , ? , ?)");
			
			
			
			StringBuilder sb2 = new StringBuilder();
			sb.append("UPDATE employees")
			.append(" SET salary = salary+ 500")
			.append(" WHERE department_id=?");
			
			try {
			Class cls =Class.forName(driver);
			
			//데이터베이스 연결
			con=DriverManager.getConnection(url,userid,passwd);
			con.setAutoCommit(false);
			//사원등록
			pstmt=con.prepareStatement(sb.toString()); 
			pstmt.setString(1, employee.getFirstName());
			pstmt.setString(2, employee.getLastName());
			pstmt.setString(3, employee.getEmail());
			pstmt.setString(4, employee.getPhoneNumber());
			pstmt.setString(5, employee.getJobId());
			pstmt.setDouble(6, employee.getSalary());
			pstmt.setInt(7, employee.getDepartmentId());
			count= pstmt.executeUpdate();
			
			//같은 부서의 모든 사원 급여 + 500;
			pstmt=con.prepareStatement(sb2.toString()); 
			pstmt.setInt(1, employee.getDepartmentId());
			count= pstmt.executeUpdate();
			con.commit();
			
			
			return count;
			}catch (Exception e) {
				con.rollback();
			} finally {
				try {
					//데이터베이스가 연결이 되어있다면
					if(con != null) con.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
					
				}
				
			}
			return count;
		}
		
	
	
	
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

//		  int count = removeDepartment("이");
//		  System.out.println(count + "부서가 삭제되었습니다");
			
		
		 int count = removeDepartment("이");
		  System.out.println(count + "부서가 삭제되었습니다");
		  Employee emp = new Employee();
		  emp.setFirstName("홍");
		  emp.setLastName("길동");
		  emp.setEmail("HONG@gmail.com");
		  emp.setPhoneNumber("010.0070.5252");
		  emp.setSalary(10000);
		  emp.setJobId("IT_PROG");
		  emp.setDepartmentId(100);
		  
		  createEmployee(emp);
		  System.out.println("신입사원 등록완료");
		
		
		}

	
	}

