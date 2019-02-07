package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientNetWorker extends Thread{
	ClientUI ui;
	
	Socket socket;	// 주 핵심연결 소켓
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// 서브소켓 (리시브용)
	
	public ClientNetWorker(String ip, ClientUI ui) {
		this.ui = ui;
		try {
			socket = new Socket(ip, 56789);
			oos = new ObjectOutputStream(socket.getOutputStream());	
			ois = new ObjectInputStream(socket.getInputStream());
			
			dataSocket = new DatagramSocket(socket.getLocalPort());	
			start();
		} catch (IOException e) {
			System.out.println("[client] network error");
			throw new RuntimeException();
		}
	}
	
	
	// 서버로 요청을 보낼때 사용할 것들을 미리 다 만들어 둘것.
	// 응답을 이벤트리스너로 넘기지 말고, 받아서 여기서 처리.
	// # 가입 요청 #
	public void sendJoinRequest(String nick, String pass) {
		String req ="join#"+nick+"#"+pass;
	//	oos.writeObject(req);
	//	Boolean resp = (Boolean)ois.readObject();
	//	ui.lb.setText();
		
	}
	
	public void sendAuthRequest(String nick, String pass) {
		String req ="auth#"+nick+"#"+pass;
	//	oos.writeObject(req);
	//	Integer resp = (Integer)ois.readObject();
		
	}
	
	public void sendUserListRequest() {
		String req ="userList";
	//	oos.writeObject(req);
	//	List resp = (List)ois.readObject();
		
	}
	
	
	
	
	
	
	// 서버측으로부터 불시에 전달받게될 알림패킷을 처리하는 부분
	public void run() {
		while(!dataSocket.isClosed()) {
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received : " +alram );
				switch(alram) {
				case "newUser":
					sendUserListRequest();	break;
				}
				
			}catch(IOException e) {
				dataSocket.close();
				break;
			}
		}
	}

}
