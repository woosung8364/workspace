package ezen.network.server;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoHandler extends Thread {
	
	private Socket socket;
	private DataInput in;
	private DataOutput out;
	
	public EchoHandler(Socket socket) throws IOException {
		this.socket = socket;
		in = new DataInputStream(socket.getInputStream());
		out = new DataOutputStream(socket.getOutputStream());
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
	
	public void echo() throws IOException {
		while(true) {
			String clientMessage = in.readUTF();
			if(clientMessage.equalsIgnoreCase("q")) {
				System.out.println("#### "+socket.getInetAddress().getHostAddress()+" 클라이언트가 접속을 끊었습니다 ####");
				break;
			}
			System.out.println("- 원격 클라이언트로부터 수신한 메시지 : " + clientMessage);
			out.writeUTF(clientMessage);
		}
		socket.close();
	}

	
	@Override
	public void run() {
		try {
			echo();
		} catch (IOException e) {
			System.err.println("에코 처리 중 예기치 않은 오류가 발생하였습니다.");
		}
	}
}
