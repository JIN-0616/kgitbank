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

public class ClientNetworker extends Thread {
	Socket socket;				//�� �ٽɿ��� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;
	ClientUI ui;
	
	DatagramSocket dataSocket;	// ������� (���ú��)
	SocketAddress serverAddress;
	
	public ClientNetworker(String ip, ClientUI ui) {
		this.ui=ui;
		try {
			socket = new Socket(ip, 56789);
			// ��ü �����Ǹ鼭, io�� Ȯ����ä�� ��������� ����. 
			// DataInOut, BufferedReader,Writer �� �̸� �ȸ����ΰ�,
			// send , receive �� �Ҷ��� ���� ����� ����. ObjectIO�� �����.
			oos = new ObjectOutputStream(socket.getOutputStream());	
			ois = new ObjectInputStream(socket.getInputStream());
			
			// clientNetwork �ʿ��� ������ �ǰ���
			dataSocket = new DatagramSocket(socket.getLocalPort());
			// tcp������Ʈ, ���ÿ� udp�� ����
			// TCP ����, UDP ���� �ȿ����°���, �ٸ� �뵵�� ���� ��Ʈ�� ����
			
			start();
			
			sendAndReceive("port#"+dataSocket.getLocalPort());	
			
		} catch (IOException e) {
			System.out.println("[client] network error");
			throw new RuntimeException();
		}
	}
	
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
	@Override
	public void run() {
		while(!dataSocket.isClosed()) {			
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received " + alram);
				switch(alram) {
				case "seatChange":
					//JOptionPane.showMessageDialog(null, "�¼������� �Ͼ��. ���Źٶ���.");
					
					// ���� ������ ���
					ui.btRefresh.doClick();	// ���θ�ɾ �ƴ� ��ư�� ������ ��� ,but UI��ü�� �������� ������ ���
					break;
				}
			} catch (IOException e) {
				dataSocket.close();
				break;
			}
		}
	}
	
	
}
