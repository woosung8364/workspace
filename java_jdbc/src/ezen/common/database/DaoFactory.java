package ezen.common.database;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Simple Factory 패턴 적용
 * @author 김기정
 *
 */
public class DaoFactory {
	
	private static DaoFactory instance = new DaoFactory();
	
	private DataSource dataSource;
	
	private String driver;
	private String url;
	private String username;
	private String password;
	
	private DaoFactory() {
		loadProperties();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("hr");
		dataSource.setPassword("hr");
		dataSource.setInitialSize(10); // 풀의 초기 커넥션 개수
		dataSource.setMaxTotal(100); // 최대 커넥션 개수
		dataSource.setMaxIdle(10); // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		dataSource.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		this.dataSource = dataSource;
	}
	
	private void loadProperties() {
		Properties prop = new Properties();
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DaoFactory getInstance() {
		return instance;
	}
	
	// MemberDao 구현체 반환
	public MemberDao getMemberDao() {
//	    피자에 필요한 토핑 가져오기
		return new JdbcMemberDao(dataSource);
	}
	
	

}
