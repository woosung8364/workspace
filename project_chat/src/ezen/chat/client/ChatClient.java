package ezen.chat.client;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import ezen.chat.protocol.MessageType;

/**
 * 전화기 역할..
 * TCP/IP 기반의 ChatClient
 */
public class ChatClient {
	
//	private static final String SERVER_IP = "localhost";
	private static final String SERVER_IP = "192.168.20.57";
	private static final int SERVER_PORT = 7777;
	
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	ChatFrame chatFrame;
	
	public ChatClient(ChatFrame chatFrame) {
		this.chatFrame = chatFrame;
	}
	
	// 서버 연결
	public void connectServer() throws IOException {
		socket = new Socket(SERVER_IP, SERVER_PORT);
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
	}
	
	// 서버 연결 종료
	public void disConnectServer() throws IOException {
		if(socket != null) {
			socket.close();
		}
	}
	
	// 메시지 전송
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message); // out 빨대로 출력
	}
	
	// 메시지 수신
	public void receiveMessage() {
		// 서버로부터 전송되는 메시지를 실시간 수신하기 위해 스레드 생성 및 시작
		Thread thread = new Thread() {
			public void run() {
				try {
					while (true) {
						String serverMessage = in.readUTF();
						String[] tokens = serverMessage.split("\\|");
						
						MessageType messageType = MessageType.valueOf(tokens[0]);
						String senderNickName = tokens[1]; // 메시지 보낸 사람의 닉네임임
						
						
						// 클라이언트 전송 메시지 종류에 따른 처리
						switch (messageType) {
							case CONNECT:
								chatFrame.appendMessage("@@@@@@@@@@ "+senderNickName+"님이 입장했습니다.@@@@@@@@@@");
								chatFrame.cleanName();
								break;
							case CHAT_MESSAGE:
								String chatMessage = tokens[2];
								chatFrame.appendMessage("["+senderNickName+"]"+chatMessage);
								break;
							case DIS_CONNECT:
								chatFrame.appendMessage("########## "+senderNickName+"님이 퇴장했습니다.##########");
								chatFrame.cleanName();
								break;
							case NICK_NAME:
								chatFrame.nameList(tokens[1]);
								break;
							case DM_MESSAGE:
								String chatMessage1 = tokens[2];
								chatFrame.appendMessage("["+senderNickName+"]"+chatMessage1);
								break;
						}
					}
				} catch (IOException e) {
					
				} 
				finally {
					
				}
			}
		};
		thread.start();
	}
}








