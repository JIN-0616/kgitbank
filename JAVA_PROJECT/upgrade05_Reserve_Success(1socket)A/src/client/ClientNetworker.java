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
			// 객체 생성되면서, io가 확보된채로 만들어지게 유도. 
			// DataInOut, BufferedReader,Writer 면 미리 안만들어두고,
			// send , receive 를 할때마 만들어도 상관은 없다. ObjectIO면 힘들다.
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
	
	// 응답은 항상 받을준비가 되어있고 보내기는 필요에 의해서 보내짐
	
	// 따라서 응답이 어떤 질의에 따른 응답인지 알수가 없다
	
	// 수정안 - 서버측에서 request와 함께 response 보내줘야 한다
	
	
}
