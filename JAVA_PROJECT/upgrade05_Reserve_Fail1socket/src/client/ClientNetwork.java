package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientNetwork extends Thread {
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
			
			start();	//�ڱ��ڽ��� ����
			
		}catch(IOException e) {
			System.out.println("[bank-client] ip error");
			throw new RuntimeException();
		}
	}
	
	public String SendRequest(String req) {
		try {			
			oos.writeObject(req);
			System.out.println("[bank-client] sent request : " + req);			
			return "success";
			
		}catch(IOException e) {
			System.out.println("[bank-client] sendAndReceive error");
			return "fail";
		}
	}
	
	@Override
	public void run() {	// �׽� �޴� ������ ����
		while(!soc.isClosed()) {
			try {
				String str = (String)ois.readObject();
				System.out.println("[client] receive response "+ str);
			} catch (IOException | ClassNotFoundException e) {
				System.out.println("[client] data receive error"+e.toString());
			}
		}
	}
}
