package ezen.shoppingmall.domain.common.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import ezen.shoppingmall.domain.article.service.ArticleService;
import ezen.shoppingmall.domain.article.service.ArticleServiceImpl;
import ezen.shoppingmall.domain.member.service.MemberService;
import ezen.shoppingmall.domain.member.service.MemberServiceImpl;

/**
 * 서비스(비즈니스) 객체 생성 및 의존관계 설정
 * 도메인(업무영역)별 객체 생성 및 조립 역할 (조립자) 
 * 싱글톤 패턴 적용
 * @author 김기정
 */
public class ServiceFactory {
	
	private static ServiceFactory instance = new ServiceFactory();
	
	
//	데이타베이스의 커넥션 풀을 관리하는 인터페이스 생성
	private DataSource dataSource;
	private DaoFactory daoFactory = DaoFactory.getInstance();

//	데이터 베이스 접속정보를 저장하는 변수들
	private String driver;
	private String url;
	private String username;
	private String password;
	
	
	private ServiceFactory() {
//		jdbc.properties 파일로부터 데이터베이스 접속 정보를 로드 
		loadProperties();
		
//		BasicDataSource를 사용하여 데이터베이스 커넥션 풀을 설정
		BasicDataSource dataSource = new BasicDataSource();
//		데이터베이스 드라이버 클래스 이름을 설정합니다
		dataSource.setDriverClassName(driver);
//		데이터베이스 접속 URL을 설정합니다
		dataSource.setUrl(url);
//		데이터베이스 접속에 사용할 사용자 이름을 설정합니다. 
		dataSource.setUsername(username);
//		데이터베이스 접속에 사용할 사용자 비밀번호를 설정합니다.
		dataSource.setPassword(password);
		
		
		dataSource.setInitialSize(5);      // 풀의 초기 커넥션 개수
		dataSource.setMaxTotal(10);        // 최대 커넥션 개수
		dataSource.setMaxIdle(5);          // Idle 상태에 풀이 소유하는 최대 커넥션 개수
		dataSource.setMaxWaitMillis(1000); // 커넥션이 존재하지 않을 때 커넥션 획득에 대기할 시간
		
//		dataSource 객체를 클래스의 dataSource 필드에 할당합니다
//		클래스 내 다른 메서드에서도 dataSource 객체를 사용할 수 있습니다.
		this.dataSource = dataSource;
	}
	
	
//	jdbc.properties 파일로부터 데이터베이스 접속 정보를 읽어와서 필드 변수들에 설정하는 메서드
	private void loadProperties() {
//		Java에서 속성(property) 파일을 다루기 위해 사용되는 클래스 생성
		Properties prop = new Properties();
		
//		클래스 패스에 있는 jdbc.properties 파일을 읽어오는 입력 스트림(InputStream)을 생성합니다.
//		getClass()는 현재 loadProperties() 메서드를 호출하는 클래스(ServiceFactory)를 나타냅니다.
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
			
//			Properties 객체인 prop에 입력 스트림에서 읽어온 jdbc.properties 파일의 내용을 로드합니다.
//			이로써 prop 객체에는 jdbc.properties 파일에 정의된 속성(key-value)들이 저장되게 됩니다.
			prop.load(in);
			
//			jdbc.properties 파일에서 "database.driver"라는 키에 해당하는 값을 읽어와서 driver 필드 변수에 저장합니다
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	ServiceFactory 클래스의 싱글톤 인스턴스를 반환하는 정적 메서드입니다.
	public static ServiceFactory getInstance() {
		return instance;
	}
	
//	MemberServiceImpl의 생성자를 호출하여 dataSource와 jdbcMemberDao 객체를 인자로 전달합니다.
	public MemberService getMemberService() {
		// MemberServiceImpl 생성 및 생성자를 이용한 의존관계 설정
		return new MemberServiceImpl(dataSource, daoFactory.getMemberDao());
	}
	
	public ArticleService getArticleService() {
		return new ArticleServiceImpl(dataSource, daoFactory.getArticleDao());
	}
	
	// 도메인(업무영역)별 xxxxService 객체 생성 및 반환 
}
