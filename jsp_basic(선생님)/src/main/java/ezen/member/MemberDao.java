package ezen.member;

/**
 * 데이터 베이스 회원 관리 명세
 *  @author 김기정
 *
 */
public interface MemberDao {
	
	public boolean create(Member member);
	public Member findByUser(String id, String passwd);
	
}
