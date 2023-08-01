package ezen.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * 
 * @author i7C- 송우성
 *
 */
public final class EzenDriver implements Driver {
	
	
	//정적 초기화 블록 , 프로그램이 실행될때 가장먼저 초기화 되는 항목
	static {
	Class cls = EzenDriver.class;
	try {
		DriverManager.registerDriver((Driver)cls.newInstance());
		System.out.println("EzenDriver가 생성되었고 , DriverManager에 등록완료");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
		
		
		
	}

	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("ezen.jdbc.EzenDriver");
		
	}
	
	
	
	
	
	
	

}


