package ezen.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import ezen.chat.protocol.MessageType;

public class ChatServer {

	//서버포트
	private static final int SERVER_PORT = 7777;
	//서버소켓변수
	private ServerSocket serverSocket;
	private boolean running;
	private Map<String, ChatHandler> clients;

	
	/** ChatServer 구동 */
	public void startup() throws IOException {
//		서버포트를 매개변수로한 서버소켓 클래스 생성
		serverSocket = new ServerSocket(SERVER_PORT);
		
		//서버 구동시 출력되는 메시지
		System.out.println("========= [ChatServer(" + SERVER_PORT + ")] Start =========");
		running = true;
//		HashTable 클래스를 대입한 clients 객채 생성
		clients = new Hashtable<String, ChatHandler>();
		try {
			while (running) {
				System.out.println("[ChatServer(" + SERVER_PORT + ")] ChatClient Connect Listenning ..");
				//클라이언트의 연결 요청을 수락하고 클라이언트와 통신하기 위한 소켓 생성
				Socket socket = serverSocket.accept();
				System.out.println("[ChatCleint(" + socket.getInetAddress().getHostAddress() + ")] 연결해옴...");

				// 데이터 송수신 스레드 생성 및 실행
				ChatHandler chatHandler = new ChatHandler(socket, this);
				
				//clients.put("닉네임", chatHandler);
				chatHandler.start();
			}
		} catch (IOException e) {
			System.err.println("[ChatServer(" + SERVER_PORT + ")] 실행 중 아래와 같은 오류가 발생하였습니다.");
			System.err.println("오류 내용 :  " + e.getMessage());
		}
	}

	
	



	/** 접속한 클라이언트를 콜렉션에 추가 */
	public void addChatClient(ChatHandler chatHandler) {
		clients.put(chatHandler.getName(), chatHandler);
		System.out.println("[현재 채팅에 참여중인 클라이언트 수] : " + clients.size());
	}

	

	/** 접속한 클라이언트를 콜렉션에 제거 */
	public void removeChatClient(ChatHandler chatHandler) {
		clients.remove(chatHandler.getName());
		System.err.println("[현재 채팅에 참여중인 클라이언트 수] : " + clients.size());
	}

	/** 접속한 모든 클라이언트에게 메시지 전송 
	 * @throws IOException */
	public void sendMessageAll(String message) throws IOException {
		Collection<ChatHandler> list = clients.values(); 
		for (ChatHandler chatHandler : list) {
			chatHandler.sendMessage(message);
		}
	}
	
	//귓속말 전송
	public void sendMessageWho(String message) throws IOException {
		String[] tokens = message.split("\\|");
		String sendName = tokens[3];
		String receiveName = tokens[1];
		Collection <ChatHandler> list = clients.values();
		for (ChatHandler chatHandler : list) {
			if (chatHandler.getNickName().equals(sendName)||chatHandler.getNickName().equals(receiveName)) {
				chatHandler.sendMessage(message);
			}
		}
	}
	
	//접속인원리스트
	public Collection<ChatHandler> getClients(){
		Collection<ChatHandler> list = clients.values();
		return list;
	}
	
	
	public void getList() throws IOException {
		Collection<ChatHandler> list = clients.values();
		Collection<ChatHandler> names = getClients();
		for (ChatHandler chatHandler : list) {
				for(ChatHandler name : names) {
				chatHandler.sendList(MessageType.NICK_NAME+"|"+name.getNickName());
				}
			}
	}
	
	
	

	/** ChatServer 종료 */
	public void shutdown() {
		try {
			serverSocket.close();
			System.err.println("[ChatServer(" + SERVER_PORT + ")] 종료됨...");
		} catch (IOException e) {
		}
	}

}
