import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * ��Ʈ��ũ�� �̿��ؼ� �����͸� �����ϴ� ����� 
 * UDP �� TCP �ΰ����� �ִٰ� �ߴµ�, 
 * DatagramSocket, DatagramPacket �� �̿��� UDP ��ȯ�� ���� �н��Ͽ���.
 * 
 *  �̹����� TCP ����� ��ȯ�� �ϰ��� �Ҷ� ����ϴ� 
 *  Socket , ServerSocket ��ü�� ���� �˾ƺ���.	
 * 
 */
public class Source04_Network_Client {
	public static void main(String[] args) {
		/*
		 * TCP ����� UDP�� �ٸ��� ������ ��ȯ�� ���ؼ� 
		 * �ϴ� ����ϰ��� �ϴ� ����� �� ������ �Ǿ�� �Ѵ�.
		 *  
		 *  ���� ���캼 �ڵ�� �������� �����Ͽ� �����͸� ������ ������ �޴� �۾��̴�.
		 */
		try {
			Socket socket = new Socket("192.168.10.27", 56789);	// �������� ���� (��ȭ�� �Ŵ� ��).	
			// ���ϰ�ü ������ �Ѱ����� �ִ°� �ƴ�����, 
			// �� ������ �����ϰ��� �ϴ� ����� ip(String)�� port(int) �� �����ϸ鼭 ������Ų��.
			// �̰�ü�� �̿��ؼ� ����� ����ȴ�.
			// Socket�� UDP�� DatagramSocket ��ü�ʹ� �ٸ���,  ����� 1:1�� ������ �����Ǵ� ��ü�̴�.
			// ��ü ������ �����ϰ� �Ǹ�, ����� ������ ��ٴ� ��!
			System.out.println("[client] connect to opposite in " + socket.getLocalPort());
			// �ڽ��� ��Ʈ�� ���� ��Ʈ�� ����.
			// ������ �ǰ� ����, UDP ���� �� ������� �ִ�.
			// socket ��ü�� �����ǰ� �������� io stream ��ü�� ��������µ�, 
			InputStream is = socket.getInputStream();	// ������ �����°� �޴� ��ü
			OutputStream os = socket.getOutputStream();	// ���濡�� ������ ����ϴ� ��ü
			/*
			 * TCP�� In, Out �� 
			 * DataIn,Out | ObjectIn, Out |  BufferedReader, BufferedWriter 
			 * PrintWriter, Scanner �� ������� �����͸� ��ȯ�Ҽ� �ִ�.
			 * 
			 * ���� ��� DataIn,Out�� �̿��ؼ� ��ȯ�� �غ���. 
			 */
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			
			String req = "join#saan#1q2w3e4r#����ȣ";
			dos.writeUTF(req);
			System.out.println("[client] send : " + req);
			
			String resp = dis.readUTF();
			System.out.println("[client] received : " + resp);
			
			
			System.out.println("[client] done");
			
			
		}catch(IOException e) {
			System.out.println("[client] socket error " + e.toString());
		}
	
	}
	
}
