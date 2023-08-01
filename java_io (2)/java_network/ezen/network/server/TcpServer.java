package ezen.network.server;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TcpServer {

	public static void main(String[] args) {
		//ip주소는 줄 필요없고 몇번 네트워크 포트를 쓰고있는지 포트만 지정하면 된다
		
		//한번 사용후 추가 사용시 이미 서버에 들어가있기때문에 충돌나서 오류가 발생된다
		int serverPort = 7777;
		
		try {
			//서버 생성
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("타임 서버["+serverSocket.getLocalPort()+"]가 정상 실행되었습니다..");
			
			//연결을 수신하기 위한 블락메소드 : 연결을 수신하기 위해 대기중
			 
			//서버는 365일동안 계속 실행되어 있어야 하므로
			while(true) {
				Socket socket = serverSocket.accept(); //블락메소드
				String clientIP = socket.getInetAddress().toString();
				System.out.println(clientIP+ " 클라이언트 연결해옴...");
				
				//출력을 위한 출력 스트림 생성
//				OutputStream out = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				pw.printf("%1$tF %1$tT" , Calendar.getInstance());
				socket.close();
			}
			
		} catch (IOException e) {
			System.out.println(serverPort+"충돌로 서버를 실행할 수 없습니다.");
		
		}
		
	}

}
