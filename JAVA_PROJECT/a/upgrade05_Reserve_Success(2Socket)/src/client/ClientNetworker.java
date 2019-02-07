package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

import javax.swing.JOptionPane;

import org.omg.CosNaming.IstringHelper;

public class ClientNetworker extends Thread{
	ClientUI ui;
	
	Socket socket;	// 주 핵심연결 소켓
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// 서브소켓 (리시브용)
	SocketAddress serverAddress;
	
	public ClientNetworker(String ip, 	ClientUI ui) {
		this.ui = ui;
		try {
			socket = new Socket(ip, 56789);
			// 객체 생성되면서, io가 확보된채로 만들어지게 유도. 
			// DataInOut, BufferedReader,Writer 면 미리 안만들어두고,
			// send , receive 를 할때마 만들어도 상관은 없다. ObjectIO면 힘들다.
			oos = new ObjectOutputStream(socket.getOutputStream());	
			ois = new ObjectInputStream(socket.getInputStream());
			
			dataSocket = new DatagramSocket(socket.getLocalPort());	
			// TCP로 열린 포트번호, 같은 포트번호 로 UDP 를 열자.
			// TCP 동시, UDP 동시에 안열리는거지, 다른 용도면 같은 포트로 열림.
			start();
			// clientNetworker 쪽에서.. 생성이 되고 나면,
		} catch (IOException e) {
			System.out.println("[client] network error");
			throw new RuntimeException();
		}
	}
	
	public void run() {
		while(!dataSocket.isClosed()) {
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received : " +alram );
				switch(alram) {
				case "seatchange":
					// JOptionPane.showMessageDialog(null, "좌석변동이 일어났다. 갱신바란다.");
					// ui.btRefresh.doClick();
					String r = sendAndReceive("all");
					break;
				}
			}catch(IOException e) {
				dataSocket.close();
				break;
			}
		}
	}

	//==============================================================
	public String sendAndReceive(String req) {
		try {
			oos.writeObject(req);
			System.out.println("[client] sent request : " + req);
			String resp =(String)ois.readObject();
			System.out.println("[client] received response : " + resp);
			return resp;
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[client] data exchange failed : "+ e.toString());
			return "error";
		}
	}
}
