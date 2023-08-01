package ezen.chat.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

import ezen.chat.protocol.MessageType;

public class ChatHandler extends Thread {
	
	private Socket socket;
	private DataInput in;
	private DataOutput out;
	private ChatServer chatServer;
	private String nickName;
	private boolean running;
	
	public ChatHandler(Socket socket, ChatServer chatServer) throws IOException {
		this.socket = socket;
		this.chatServer = chatServer;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
		running = true;
		
//		String clientMessage =in.readUTF();
//		String[] tokens =clientMessage.split("\\|"); // |
//		nickName = tokens[1];
//		chatServer.addChatClient(this); // 자기자신 (쳇 핸들러..)
//		start();
//		chatServer.sendMessageAll(clientMessage); //전체에 보이게 하려면 여기서.. //CONNECT|방그리
	}
	
	public Socket getSocket() {
		return socket;
	}

	public DataInput getIn() {
		return in;
	}

	public DataOutput getOut() {
		return out;
	}
	
	public ChatServer getChatServer() {
		return chatServer;
	}

	public String getNickName() {
		return nickName;
	}

	
	public void process() throws IOException {
		
		while(running) {
			//파싱되지 않은 클라이언트 메시지
			String clientMessage = in.readUTF();
			System.out.println("[디버깅] : "+clientMessage); // 이거 디버깅용
			
			// 클라이언트 메시지 파싱
			String[] tokens =clientMessage.split("\\|");
			// 메시지 유형
			MessageType messageType = MessageType.valueOf(tokens[0]);
			// 클라이언트 전송 메시지 종류에 따른 처리
			switch (messageType) {
				case CONNECT:
					nickName=tokens[1];
					chatServer.addChatClient(this);
					chatServer.sendMessageAll(clientMessage);
					
					// 연결된 모든 클라이언트 닉네임 목록 전송 구현
					chatServer.getList();
					
					break;
				// 다중 채팅 메시지
				case CHAT_MESSAGE:
					chatServer.sendMessageAll(clientMessage);
					break;
				// 연결 종료 메시지
				case DIS_CONNECT:
					nickName=tokens[1];
					chatServer.removeChatClient(this);
					chatServer.sendMessageAll(clientMessage);
					
					// 연결된 모든 클라이언트 닉네임 목록 전송 구현 - 줄어드니까
					chatServer.getList();
					running=false;
					break;
				case DM_MESSAGE:
					chatServer.sendMessageWho(clientMessage);
					break;
			}
		}close();
	}
	
	// 자기 자신에게 메시지 출력
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);		
	} 
	// 자기 자신에게 목록 출력
	public void sendList(String message) throws IOException {
		out.writeUTF(message);
	}
	
	public void close() {
		if(socket!=null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	
	@Override
	public void run() {
		try {
			process();
			System.out.println("[ChatClient("+nickName+")]님이 연결을 종료하였습니다..");
		} catch (IOException e) {
			System.err.println("에코 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
