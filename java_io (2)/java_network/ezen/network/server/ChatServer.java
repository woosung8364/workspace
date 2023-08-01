package ezen.network.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Hashtable;

public class ChatServer {

	static Hashtable<String, ChatHandler> clients = new Hashtable<String, ChatHandler>();

	/*
	 * 서버에 연결한 모든 클라이언트 들에게 메시지 전송
	 */

	public static void sendMessageAll(String message) throws IOException {
		Collection<ChatHandler> list = clients.values();
		for (ChatHandler chatHandler : list) {
			chatHandler.sendMessage(message);
		}
	}

	public static void main(String[] args) {
		
		// ip주소는 줄 필요없고 몇번 네트워크 포트를 쓰고있는지 포트만 지정하면 된다
		// 한번 사용후 추가 사용시 이미 서버에 들어가있기때문에 충돌나서 오류가 발생된다
		int serverPort = 7777;

		
		
		
		                                                                                                                                                                                            
		try {
			// 서버 생성
			ServerSocket serverSocket = new ServerSocket(serverPort);
			System.out.println("채팅 서버[" + serverSocket.getLocalPort() + "]가 정상 실행되었습니다..");

			// 연결을 수신하기 위한 블락메소드 : 연결을 수신하기 위해 대기중

			// 서버는 365일동안 계속 실행되어 있어야 하므로

			while (true) {
				Socket socket = serverSocket.accept(); // 블락메소드
				String clientIP = socket.getInetAddress().getHostAddress();
				System.out.println(clientIP + " 클라이언트 연결해옴...");
//				데이터 수신 및 송신 스레드 생성 및 실행
				ChatHandler chatHandler = new ChatHandler(socket);
				
				//접속한 ip를 키로 쓰고 echoHandler 클래스를 실행
				clients.put(clientIP, chatHandler);
				
				
				
				// echohandler 에서 thread 클래스 상속시
				chatHandler.start();

				/*
				 * Runnalble 인터페이스 사용시
				 */
//				Thread thread = new Thread(echoHandler);
//				thread.start();

//				Thread thread = new Thread(new Runnable()) {
//					@Override
//					public void run() {
//						
//						}
//					}
			}

		} catch (IOException e) {

			System.out.println("채팅 서버와 연결할 수 없습니다");

		}

	}
}
