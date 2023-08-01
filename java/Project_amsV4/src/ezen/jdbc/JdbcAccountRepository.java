package ezen.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ezen.ams.domain.Account;
import ezen.ams.domain.AccountRepository;



/**
 * @author USER 송우성
 * 
 */
public class  JdbcAccountRepository implements AccountRepository{
		
//	static 변수선언
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String userid = "hr";
	private static String passwd2 = "hr";

	
//	생성자 선언
	public JdbcAccountRepository() {}
	
	
//	계좌를 새로 테이블에 추가하기 위한 메소드
	public int addAccounts(String accountType, String accountNum ,String accountOwner , int passwd , int restMoney) {
		 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		int count = 0;
		
		//쿼리명령문을 보내기 위한 클래스 생성
		
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO account(account_type, account_num, account_owner, passwd, rest_money)") 
		.append(" Values(account_num_seq.NEXTVAL, ?,  ?, ?, ?)");
	
		
		try {
		
//		드라이버 불러들이기
		Class.forName(driver);
		
//		데이타베이스 연결
		con = DriverManager.getConnection(url, userid, passwd2);	
		
//		sql 쿼리를 실행하기위해 prepareStatement 객체 생성
		pstmt =con.prepareStatement(sb.toString());
	
		
		//값을 수정해보기
		// setString(?의 순서 , 값) 
		//바인딩변수에 매게변수를 대입함
		pstmt.setString(1, accountNum);
		pstmt.setString(2,accountOwner);		
		pstmt.setInt(3, passwd);
		pstmt.setInt(4, restMoney);

	
//		prepareStatement  객체를 활용해 결과값 출력
		count = pstmt.executeUpdate();
		rs = pstmt.executeQuery();
		con.commit();
		
		
		
		}catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				//데이터베이스가 연결이 되어있다면
				if(con != null) con.close();
				// preparestatement 객체가 생성되어있다면
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
//				컴파일 예외를 런타임 예외로 변환
				throw new RuntimeException("계좌 조회를 시도하는 도중 아래와 같은 에러가 발생하였습니다...");
			}
			
		} 
		return count;
	}
	
	
//	전체계좌의 갯수  리턴받기 위한 메소드
	public int getCount() {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
		
			int count=0;
		
			//쿼리
			
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT count(*) cnt")
			.append(" FROM account");
		
			
			try {
				
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd2);	
			//사원등록
			pstmt =con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			
			if (rs.next()) {
				count = rs.getInt("cnt");
			}
			
		
			
			}catch (ClassNotFoundException | SQLException e) {

				
			} finally {
				try {
					//데이터베이스가 연결이 되어있다면
					if(con != null) con.close();
					// preparestatement 객체가 생성되어있다면
					if(pstmt != null) pstmt.close();
				} catch (Exception e) {
//					컴파일 예외를 런타임 예외로 변환
					throw new RuntimeException("계좌 등록시 아래와 같은 에러가 발생하였습니다...");
				}
				
			} 
			return count;
	}


//	전체계좌정보를 리턴받기 위한 메소드
	
	@Override
	public List<Account> getAccounts() {
		
		
//		Account 객체를 담기위한 배열 클래스 생성
		List<Account> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//쿼리명령문을 보내기 위한 클래스 생성
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT account_type ,account_num , account_owner, passwd , rest_money") 
		.append(" FROM account");
	
		
		try {
		
//		드라이버 불러들이기
		Class.forName(driver);
		
//		데이타베이스 연결
		con = DriverManager.getConnection(url, userid, passwd2);	
		
//		sql 쿼리를 실행하기위해 prepareStatement 객체 생성
		pstmt =con.prepareStatement(sb.toString());
		
//		prepareStatement  객체를 활용해 결과값 출력
		rs = pstmt.executeQuery();
		
		list=new ArrayList<Account>();
		con.commit();
		
		
//		조건문 : 다음행이 존재한다면
		while(rs.next()) {
			String accountType=rs.getString("account_type");
			String accountNum= rs.getString("account_num");
			String accountOwner =rs.getString("account_owner");
			int passwd = rs.getInt("passwd");
			int restMoney = rs.getInt("rest_money");
			System.out.println(accountType + "\t" + accountNum + "\t" + accountOwner + "\t" + passwd + "\t" +
			restMoney); 
			Account account = new Account();
			account.setAccountType(accountType);
			account.setAccountNum(accountNum);
			account.setAccountOwner(accountOwner);
			account.setPasswd(passwd);
			account.setRestMoney(restMoney);
			list.add(account);
		}
		
		}catch (ClassNotFoundException | SQLException e) {

			
		} finally {
			try {
				//데이터베이스가 연결이 되어있다면
				if(con != null) con.close();
				// preparestatement 객체가 생성되어있다면
				if(pstmt != null) pstmt.close();
			} catch (Exception e) {
//				컴파일 예외를 런타임 예외로 변환
				throw new RuntimeException("계좌 조회를 시도하는 도중 아래와 같은 에러가 발생하였습니다...");
			}
			
		} 
		
		
		
		
		return list;
	}


	/*
	 * 06/14 추가됨
	 */
	public void close() {
		Connection con =null;
		if(con != null) {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
	@Override
	public Account searchAccount(String accountNum) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Account> searchAccountByOwner(String accountOwner) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean removeAccout(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean addAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean removeAccount(String accountNum) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	//디버깅을 위한 메인 메소드
	public static void main(String[] args) {
		
		//전체 계좌 갯수를 세기위한 디버깅용 코드
		JdbcAccountRepository jdbc;
		jdbc = new JdbcAccountRepository();
//		jdbc.getCount();
//		System.out.println(jdbc.getCount());
		
		
//		List<Account> list=jdbc.getAccounts();
//		for (Account account : list) {
//			System.out.println(account);
//		}
		
		
		
		int addAccounts = jdbc.addAccounts("일반" , "" , "송우성" , 1234 , 10000);
		System.out.println(addAccounts + "계좌가 등록되었습니다");
		
	}



	
	
	
	
	
}