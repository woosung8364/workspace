package ezen.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS 와의 통신을 이용해 도메인네임을 IP주소로 정보 제공
 * @author i7C- 송우성
 *
 */


public class InetAddressExample {
		
	
	
		//기본 내장 클래스 InetAddress 를 사용하기 위해선 예외처리를 해줘야한다
	public static void main(String[] args) throws UnknownHostException {
		
		
		//변수선언공간
		String localIP = null;
		InetAddress inetAddress = InetAddress.getLocalHost();
		
		// 내 컴퓨터의 ip 주소 알아내기
		localIP = inetAddress.getHostAddress();
		System.out.println("내 컴퓨터의 IP주소 : " + localIP);
		
		
		//도메인을 이용해 구글의 실제 ip 주소 알아내기
		String domainName = "www.twitch.com";
		String naverIP = null;
		inetAddress = InetAddress.getByName(domainName);
		System.out.println(inetAddress.getHostAddress());
		
		
		//여러개의 서버로 구성되어있는 홈페이지의 ip주소 알아내기
		InetAddress[] multiIPs=inetAddress.getAllByName(domainName);
		for (InetAddress inetAddress2 : multiIPs) {
			System.out.println(inetAddress2);
		}
		
		
		
	}

}
