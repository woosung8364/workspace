package ezen.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 이용해 도메인네을 IP주소 정보 제공 
 * @author 김기정
 *
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		String localIp = null;
		InetAddress inetAddress = InetAddress.getLocalHost();
		localIp = inetAddress.getHostAddress();
		System.out.println("내컴떠의 IP주소: " + localIp);
		
//		String domainName = "www.naver.com";
//		String domainName = "www.google.com";
		String domainName = "www.daum.net";
		String naverIp = null;
		inetAddress = InetAddress.getByName(domainName);
		System.out.println(inetAddress.getHostAddress());
		
		InetAddress[] mutiIps = InetAddress.getAllByName(domainName);
		for (InetAddress inet : mutiIps) {
			System.out.println(inet);
		}
	}

}










