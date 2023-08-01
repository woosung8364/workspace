package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;

public class PortScanner {

	/**
	 * ServerSocket을 이용한 포트 스캐너 
	 * 내 컴퓨터에는 몇번 포트가 사용중인지 확인하는게 목적
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("내 컴퓨터에서 사용중인 포트 번호 목록");
		
		
		//포트는 65535 까지 있으니 i값을 65535로 설정
		for (int i = 0; i < 65535; i++) {
			try {
				ServerSocket serverSocket = new ServerSocket(i);
			} catch (IOException e) {
				System.out.println("포트:   "+i);
			}
		}
		
		
		
		
		
		
	}

}
