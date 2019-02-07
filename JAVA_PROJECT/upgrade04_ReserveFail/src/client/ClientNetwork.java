package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientNetwork {
	Socket soc;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	public ClientNetwork(String ip) {
		try {
			soc = new Socket(ip,56789);
			// 객체 생성되면서, IO를 확보한채로 만들어지게 유도
			// DataInOut, BufferedReader, Writer 만 미리 안만들어두고,
			// send, receive 를 할때마다 만들어도 상관없다
			
			// 단, Object는 힘들다
			// 입출력 생성시에 4byte header가 생성됨
			// 따라서, Object는  S - C 순서에 유의할것
			// ex) 서버에서 output input으로 만들면 client는 input output 순으로
			//     (!!! 둘다 input을 먼저 만들려할려면 error)
			// ==> 이러한 이유로서 메소드에 생성할시 객체를 재생성하지 않고
			//    미리 만들어두고 사용한다.
			
			System.out.println("[bank-client] network start");
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
		}catch(IOException e) {
			System.out.println("[bank-client] ip error");
			throw new RuntimeException();
		}
	}
	
	public String sendAndReceive(String req) {
		try {
			oos.reset();
			oos.writeObject(req);
			System.out.println("[bank-client] sent request : " + req);
			String resp =(String)ois.readObject();
			System.out.println("[client] received response : " + resp);
			return resp;
			
		}catch(IOException | ClassNotFoundException e) {
			System.out.println("[bank-client] sendAndReceive error");
			return "error";
		}
	}		
}
