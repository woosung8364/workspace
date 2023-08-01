package ezen.common.database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	private String driver;
	private String url;
	private String username;
	private String password;

	private ConnectionFactory() {
		
		loadProperties();
		try {
			Class.forName(driver);
		} catch (Exception e) {}
	}

	private void loadProperties() {
//		프로퍼티 객체 생성
		Properties prop = new Properties();
		
//		리소스 파일 지정
		InputStream in = getClass().getResourceAsStream("/config/jdbc.properties");
		try {
//			프로퍼티 파일 안에 있는 키값 불러들여오기
			prop.load(in);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.username = prop.getProperty("database.username");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ConnectionFactory getInstance() {
		return instance;
	}

	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}

	// 테스트를 위한 main
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection con = connectionFactory.getConnection();
		System.out.println("얻어온 커넥션: " + con);
		con.close();
	}

}















