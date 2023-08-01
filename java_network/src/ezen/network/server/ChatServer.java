package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;

public class ChatServer {
	
	static Hashtable<String, ChatHandler> clients = new Hashtable<String, ChatHandler>();
	
	/**
	 * 서버에 연결한 모든 클라이언트들에게 메시지 전송
	 * @param message
	 * @throws IOException 
	 */
	public static void sendMessageAll(String message) throws IOException {
		Collection<ChatHandler> list = clients.values();
		for (ChatHandler chatHandler : list) {
			chatHandler.sendMessage(message);
		}
	}

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
				ChatHandler chatHandler = new ChatHandler(socket);
				clients.put(clientIp, chatHandler);
				chatHandler.start();
			}
			
			
		} catch (IOException e) {
			System.out.println("포트("+serverPort+") 충돌로 서버를 실행할 수 없습니다..");
		}

	}

}
