                                                                                                                                                                                      package ezen.chat.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ezen.chat.protocol.MessageBuilder;
import ezen.chat.protocol.MessageType;
import ezen.chat.server.handler.ChatMessageHandler;
import ezen.chat.server.handler.ConnectMessageHandler;
import ezen.chat.server.handler.DisConnectMessageHandler;
import ezen.chat.server.handler.DmMessageHandler;
import ezen.chat.server.handler.MessageListener;

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
//		chatServer.addChatClient(this);
//		start();
//		chatServer.sendMessageAll("@@@@@ "+nickName+"님이 연결하였습니다 @@@@@");
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
			// 파싱되지 않은 클라이언트 메시지
			String clientMessage = in.readUTF();
			System.out.println("[디버깅] : " + clientMessage);
			
			// 클라이언트 메시지 파싱
//			String[] tokens = clientMessage.split("\\|");
			String[] tokens = MessageBuilder.parse(clientMessage);
			// 메시지 유형
			MessageType messageType = MessageType.valueOf(tokens[0]);
//			String senderNickName = tokens[1];
			
			// 메시지 리스너
			MessageListener messageListener = null;

			// 클라이언트 전송 메시지 종류에 따른 처리
			switch (messageType) {
				// 연결 메시지
				case CONNECT:
					// 연결한 클라이언트 닉네님
					nickName = tokens[1];
					messageListener = new ConnectMessageHandler();
					break;
				// 다중 채팅 메시지
				case CHAT_MESSAGE:
					messageListener = new ChatMessageHandler();
					break;
				// DM 메시지
				case DM_MESSAGE:
					messageListener = new DmMessageHandler();
					break;
				// 연결 종료 메시지
				case DIS_CONNECT:
					messageListener = new DisConnectMessageHandler();
					running = false;
					break;
			}
			messageListener.doResponse(chatServer, this, clientMessage);
		}
		close();
	}

	// 자기 자신에게 메시지 출력
	public void sendMessage(String message) throws IOException {
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
			System.out.println("[ChatCleint("+nickName+")]님 연결을 종료하였습니다..");
		} catch (IOException e) {
			System.err.println("채팅 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
