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
			// ��ü �����Ǹ鼭, IO�� Ȯ����ä�� ��������� ����
			// DataInOut, BufferedReader, Writer �� �̸� �ȸ����ΰ�,
			// send, receive �� �Ҷ����� ���� �������
			
			// ��, Object�� �����
			// ����� �����ÿ� 4byte header�� ������
			// ����, Object��  S - C ������ �����Ұ�
			// ex) �������� output input���� ����� client�� input output ������
			//     (!!! �Ѵ� input�� ���� ������ҷ��� error)
			// ==> �̷��� �����μ� �޼ҵ忡 �����ҽ� ��ü�� ��������� �ʰ�
			//    �̸� �����ΰ� ����Ѵ�.
			
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
