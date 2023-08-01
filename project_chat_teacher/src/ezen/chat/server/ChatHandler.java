package ezen.chat.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.Set;

import ezen.chat.client.ChatFrame;
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

//		String clientMessage = in.readUTF();
//		String[] tokens = clientMessage.split("\\|");
//		nickName = tokens[1];
//
//		chatServer.addChatClient(this);
//		start();
//
////		chatServer.sendMessageAll("@@@@@ "+nickName+"님이 연결하였습니다 @@@@@");
//		chatServer.sendMessageAll(clientMessage); // CONNECT|방그리
	}

	public ChatServer getChatServer() {
		return chatServer;
	}

	public String getNickName() {
		return nickName;
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

	public void process() throws IOException {

		while (running) {

			String clientMessage = in.readUTF();

			System.out.println("[디버깅] : " + clientMessage);

			String[] tokens = clientMessage.split("\\|");

			MessageType messageType = MessageType.valueOf(tokens[0]);
//			String senderNickName = tokens[1];

			// 클라이언트 전송 메시지 종류에 따른 처리
			Collection<ChatHandler> list = chatServer.getClients();
			
			switch (messageType) {
			case CONNECT:
				// 연결한 클라이언트 닉네임
				nickName = tokens[1];
				chatServer.addChatClient(this);
				chatServer.sendMessageAll(clientMessage);
				
				//연결한 모든 클라이언트 닉네임 목록 구현
				
				chatServer.getList();
				
				
			case CHAT_MESSAGE:
				chatServer.sendMessageAll(clientMessage);
				break;
			case DIS_CONNECT:
				nickName=tokens[1];
				chatServer.removeChatClient(this);
				chatServer.sendMessageAll(clientMessage);
				
				chatServer.getList();
				
				running = false;
				break;
	
			case DM_MESSAGE:
				chatServer.sendMessageWho(clientMessage);
				break;
			}
		}
		close();
	}

	// 자기 자신에게 메시지 출력
	public void sendMessage(String message) throws IOException {
		out.writeUTF(message);
	}
	
	public void sendList(String message) throws IOException {
		out.writeUTF(message);
	}

	public void close() {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		try {
			process();
		} catch (IOException e) {
			System.err.println("에코 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
