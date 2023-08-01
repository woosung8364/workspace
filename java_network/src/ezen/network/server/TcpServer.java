package ezen.network.server;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

public class TcpServer {

	public static void main(String[] args) {
		int serverPort = 7777;
		try {
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("타임 서버["+serverSocket.getLocalPort()+"]가 정상 실행되었습니다..");
			
			while(true) {
				Socket socket = serverSocket.accept(); // 블락메소드
				String clientIp = socket.getInetAddress().toString();
				System.out.println(clientIp+" 클라이언트 연결해옴..");
				
//				출력을 위한 출력 스트림 생성
				PrintWriter out = new PrintWriter(socket.getOutputStream());
				out.printf("%1$tF %1$tT", Calendar.getInstance());
				out.flush();
				socket.close();
			}
			
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다..");
		}

	}

}
