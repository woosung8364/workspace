package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

public class EchoServer {

	public static void main(String[] args) {
		
		int serverPort = 7777;
		
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("에코 서버["+serverSocket.getLocalPort()+"]가 정상 실행되었습니다..");
			
			while(true) {
				Socket socket = serverSocket.accept(); // 블락메소드
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println(clientIp+" 클라이언트 연결해옴..");
				
//				데이터 수신 및 송신 스레드 생성 및 실행
				EchoHandler echoHandler = new EchoHandler(socket);
				echoHandler.start();
			}
			
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다..");
		}

	}

}
