package ezen.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

/**
 * RDB를 통해 회원 저장 및 관리(검색, 수정, 삭제) 구현체
 * @author 송우성
 */
public class JdbcMemberDao  implements MemberDao {
		
	@SuppressWarnings("unused")
	private DataSource dataSource;
	
	
	public JdbcMemberDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

	/**
	 * 신규 등록
	 */
	public boolean create(Member member){
		boolean success = false;
		StringBuilder sb = new StringBuilder();
		sb.append(" INSERT INTO member (")
		  .append("     id,")
		  .append("     name,")
		  .append("     passwd,")
		  .append("     email )")
		  .append("  VALUES (?, ?, ?, ?)");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
			success= true;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				con.close();
			} catch (Exception e) {}
		}
		return success;
	}
	
	
	
	
	public Member findByUser(String id , String passwd) {
		Member member = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT")
		  .append("     id,")
		  .append("     name,")
		  .append("     TO_CHAR(regdate, 'YYYY-MM-DD DAY')  regdate")
		  .append(" FROM")
		  .append("     member")
		  .append(" WHERE")
		  .append("      id = ? AND passwd = ? ");

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {			
				String uid = rs.getString("id");
				String name = rs.getString("name");
				String regdate  = rs.getString("regdate");
			
				member= new Member();
				member.setId(uid);
				member.setName(name);
				member.setRegdate(regdate);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				con.close();
			} catch (Exception e) {}
		}
		return member;
	}
	
	
	@Override
	public List<Member> findByAll() {
		List<Member> list = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT")
		  .append("     id,")
		  .append("     name,")
		  .append("     email,")
		  .append("     TO_CHAR(regdate, 'YYYY-MM-DD DAY')  regdate")
		  .append(" FROM")
		  .append("     member");


		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			list = new ArrayList<Member>();
			
			if (rs.next()) {			
				String uid = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String regdate  = rs.getString("regdate");
			
				Member member= new Member();
				member.setId(uid);
				member.setName(name);
				member.setEmail(email);
				member.setRegdate(regdate);
				
				list.add(member);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {}
		}
		return list;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
//		Member member = new Member("woosun1" ,"송우성" , "1234" ,"seo8331@naver.com" ,null);
//		MemberDao dao = new JdbcMemberDao();
//		dao.create(member);
//		System.out.println("등록완료");
//		
//		Member loginMember = dao.findByUser("woosung", "1234");
//		System.out.println(loginMember);
	}


	
}


















