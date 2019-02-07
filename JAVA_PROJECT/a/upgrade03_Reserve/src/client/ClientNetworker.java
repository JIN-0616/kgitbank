package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientNetworker {
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
	
	
}
