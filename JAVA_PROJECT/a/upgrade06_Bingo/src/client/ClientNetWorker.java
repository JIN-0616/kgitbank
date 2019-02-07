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
	
	Socket socket;	// �� �ٽɿ��� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// ������� (���ú��)
	
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
	
	
	// ������ ��û�� ������ ����� �͵��� �̸� �� ����� �Ѱ�.
	// ������ �̺�Ʈ�����ʷ� �ѱ��� ����, �޾Ƽ� ���⼭ ó��.
	// # ���� ��û #
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
	
	
	
	
	
	
	// ���������κ��� �ҽÿ� ���޹ްԵ� �˸���Ŷ�� ó���ϴ� �κ�
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
