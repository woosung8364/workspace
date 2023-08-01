package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * ServerSocket을 이용한 포트 스캐너
 * @author 김기정
 *
 */
public class PortScanner {

	public static void main(String[] args) {
		System.out.println("내컴떠에서 사용중인 포트 번호 목록");
		
		for (int i = 0; i < 65535; i++) {
			try {
				ServerSocket scServerSocket = new ServerSocket(i);
			} catch (IOException e) {
				System.out.println("포트: " + i);
			}
		}		
		
		

	}

}






