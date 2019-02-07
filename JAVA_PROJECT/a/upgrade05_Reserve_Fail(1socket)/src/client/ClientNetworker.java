package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientNetworker extends Thread {
	Socket socket;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	public ClientNetworker(String ip) {
		try {
			socket = new Socket(ip, 56789);
			// ��ü �����Ǹ鼭, io�� Ȯ����ä�� ��������� ����. 
			// DataInOut, BufferedReader,Writer �� �̸� �ȸ����ΰ�,
			// send , receive �� �Ҷ��� ���� ����� ����. ObjectIO�� �����.
			oos = new ObjectOutputStream(socket.getOutputStream());	
			ois = new ObjectInputStream(socket.getInputStream());
			
			start();
			
		} catch (IOException e) {
			System.out.println("[client] network error");
			throw new RuntimeException();
		}
	}
	
	public String sendRequest(String req) {
		try {
			oos.writeObject(req);
			System.out.println("[client] sent request : " + req);
			return "success";
		} catch (IOException e) {
			System.out.println("[client] data sent failed : "+ e.toString());
			return "fail";
		}
	}
	
	public void run() {
		while(!socket.isClosed()) {
			try {
				String str = (String)ois.readObject();
				System.out.println("[client] receive response " + str);
				JOptionPane.showMessageDialog(null, "response received");
			}catch(IOException | ClassNotFoundException e) {
				System.out.println("[client] data receive error " + e.toString());
				break;
			}
		}
	}
	
	
	
	
	
	
}
