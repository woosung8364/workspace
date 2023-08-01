package ezen.common.database;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Apachie DBCP API는 1 -- DataSource를 구현한 구현체
 * Apachie DBCP API는 내부적으로 2 -- 커넥션 풀링을 구현하고 있다. (총 2개 구현됨)                                                                                     
 * @author i7C-  송우성
 * dao 가 수백개 많개는 몇천개가 존재할 수 있음
 */
public class SomeDaoExample {
	
	private DataSource dataSource;
	
	public SomeDaoExample() {
//		DBCP2 생성
//		아래부분은 별도로 분리시켜 캡슐화 시킬것임 (DAO 패턴)
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		dataSource.setInitialSize(5); // 풀의 초기 커넥션 개수
		dataSource.setMaxTotal(10); // 최대 커넥션 개수
		dataSource.setMaxIdle(5); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		dataSource.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		this.dataSource = dataSource;
	}
	
	public void select() {
		Connection con = null;
		try {
//			get connection 에선 예외가 선언되어있다
			con = dataSource.getConnection();
			System.out.println("DataSource 를 통해 얻어온 커넥션 :" + con);
			//---
			//---
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
//			사용이 끝난 connection 반납
		} finally {
//			커넥션 반납 - dataSource 객채에서 close()를 사용하면 소켓을 닫는게 아니라 커넥션 반납이됨
			try {
				con.close();
				System.out.println("사용한 커넥션 반납 완료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SomeDaoExample dao = new SomeDaoExample();
		dao.select();
	}

}
