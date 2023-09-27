package ezen.oop.collection;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) {
		
		String configFile = "database.properties";
//		상대경로
//		PropertiesExample.class.getResourceAsStream("../../../config/" + configFile); 
//		절대경로
		InputStream in = PropertiesExample.class.getResourceAsStream("/config/" + configFile); 
		
//		Class cls = PropertiesExample.class;
//		URL fileUrl = cls.getResource("/config/" + configFile); // 절대경로
//		URL fileUrl = cls.getResource("../../../config/" + configFile); // 상대경로
//		String filePath = fileUrl.getFile();
//		System.out.println(filePath);
		
		
		
		
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		프로퍼티 파일의 내용 읽기
		String driver = properties.getProperty("driver", "null");
		String fontName = properties.getProperty("fontName", "null");
		System.out.println(driver);
		System.out.println(fontName);
		
		
		
		
	}

}
