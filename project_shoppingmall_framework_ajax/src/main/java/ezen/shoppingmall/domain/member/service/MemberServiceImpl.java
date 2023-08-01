package ezen.shoppingmall.domain.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import ezen.shoppingmall.domain.common.factory.ServiceFactory;
import ezen.shoppingmall.domain.member.dao.MemberDao;
import ezen.shoppingmall.domain.member.dto.Member;

/**
 * 회원 관련 비즈니스 로직 처리 및 트랜잭션 관리 구현체
 * @author 김기정
 */
public class MemberServiceImpl implements MemberService{
	
	private DataSource dataSource;
	private MemberDao memberDao;
	
	public MemberServiceImpl(DataSource dataSource, MemberDao memberDao) {
		this.dataSource = dataSource;
		this.memberDao = memberDao;
	}

	@Override
	public Member registerMember(Member member) {
		Connection connection = null;
		try {
			// 트랜잭션 시작
			connection = dataSource.getConnection();
			connection.setAutoCommit(false);
			// memberDao 사용
			// 등록
			memberDao.create(connection, member);
			// 상세조회
			member = memberDao.findById(connection, member.getId());
			// 정상 처리 시 커밋
			connection.commit();
		} catch (Exception e) {
			try {connection.rollback();} catch (SQLException e1) {}
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return member;
	}

	@Override
	public Member isMember(String id, String passwd) {
		Member member = null;
		Connection connection = null;
		
		try {
			// select는 트랜잭션 X
			connection = dataSource.getConnection();
			member = memberDao.findByUser(connection, id, passwd);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return member;
	}

	@Override
	public List<Member> getMembers() {
		List<Member> members = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			members = memberDao.findByAll(connection);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return members;
	}

	@Override
//	회원 ID를 인자로 받아 해당 회원의 정보를 조회하여 Member 객체로 반환합니다.
	public Member readMember(String id) {
//		member 객체 생성
		Member member = null;
//		connection 객체 생성
		Connection connection = null;
		try {
//			dataSource 객체로부터 데이터베이스 커넥션을 가져와서 connection 변수에 할당합니다.
			connection = dataSource.getConnection();
//			전달받은 id를 사용하여 memberDao의 findById 메서드를 호출하여 데이터베이스에서 해당 회원의 정보를 조회합니다. 
//			객체를 인자로 전달하여 데이터베이스와 연결 상태를 유지하며 조회 작업을 수행합니다. 조회된 회원 정보가 있다면 member 변수에 저장됩니다.
			member = memberDao.findById(connection, id);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {if(connection != null) connection.close();} catch (SQLException e1) {}
		}
		return member;
	}
	
	// 테스트 메인
	public static void main(String[] args) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		MemberService memberService = serviceFactory.getMemberService();
		
//		Member member = new Member("james", "1111", "제임스", "james1@gmail.com", null);
//		member = memberService.registerMember(member);
//		System.out.println("등록 후 상세정보 : " + member);
		
//		Member loginMember = memberService.isMember("james", "1111");
//		System.out.println(loginMember);
		
//		List<Member> members = memberService.getMembers();
//		System.out.println(members);
		
		Member detailMember = memberService.readMember("bangry");
		System.out.println(detailMember);
		
	}

}
