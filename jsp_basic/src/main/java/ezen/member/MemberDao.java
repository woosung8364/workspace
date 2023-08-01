package ezen.member;

import java.util.List;

/**
 *  Data Access Object
 *  데이터 베이스 회원 관리 명세
 *  @author 송우성
 *
 */
public interface MemberDao {
	
	public boolean create(Member member);
	public Member findByUser(String id , String passwd);
	public List<Member> findByAll();
}
