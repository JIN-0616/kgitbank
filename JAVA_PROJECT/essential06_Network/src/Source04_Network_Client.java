import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * ��Ʈ��ũ�� �̿��ؼ� �����͸� �����ϴ� �����
 *  UDP�� TCP �ΰ����� �ִٰ� �ߴµ�,
 *  DatagreamSocket, DatagreamPacket�� �̿��� UDP ��ȯ�� ���� �н��Ͽ���.
 *  
 * �̹����� TCP ����� ��ȯ�� �ϰ��� �Ҷ� ����ϴ�
 *  Socket, ServerSocket ��ü�� ���� �˾ƺ���.
 *   
 */
public class Source04_Network_Client {
	public static void main(String[] args) {
		/*
		 * TCP ����� UDP�� �ٸ��� ������ ��ȯ�� ���ؼ� 
		 * �ϴ� ����ϰ��� �ϴ� ����� �� ������ �Ǿ�� �Ѵ�.
		 * 
		 * ���� ���캼 �ڵ�� �������� �����Ͽ� �����͸� ������ ������ �޴� �۾��̴�.
		 */
		
		try {
						  //new Socket(targetIP, targetPort);
			Socket socket = new Socket("192.168.10.155", 56789); // �������� ����(��ȭ�� �Ŵ°�) 
			// ��Ĺ��ü ������ �Ѱ����� �ִ°� �ƴ�����,
			// �� ������ �����ϰ��� �ϴ� ����� ip(String)�� port(int)�� �����ϸ鼭 ������Ų��.  	
			// �� ��ü�� �̿��ؼ� ����� ����ȴ�.
			// Socket�� UDP�� DatagreamSocket ��ü�ʹ� �ٸ���, ����� 1:1�� ������ �����Ǵ� ��ü�̴�.
			// ��ü ������ �����ϰ� �Ǹ�, ����� ������ ��ٴ� ��!			
			System.out.println("[Client] connect to opposite in "+socket.getLocalPort());
			// �ڽ��� ��Ʈ�� ���� ��Ʈ�� ����
			// ������ �ǰ� ����, UDP ���� �� ������� �ִ�.
			// socket ��ü���� �������� io stream ��ü�� ��������µ�,
			InputStream is = socket.getInputStream();	// ������ ������ �޴� ��ü
			OutputStream os = socket.getOutputStream(); // ���濡�� ������ ����ϴ� ��ü
			
			/*
			 * TCP�� In, Out��
			 *  Data in,out | Object in,out | BufferedReader, BufferedWriter
			 *  PrintWriter, Scanner �� ������� �����͸� ��ȯ�� �� �ִ�.
			 *  
			 *  ���� ��� DataIn,Out�� �̿��ؼ� ��ȯ�� �غ���
			 */
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			String req = "join#saan#1q2w3e4r#����ȣ";
			dos.writeUTF(req);
			String resp = dis.readUTF();			
			System.out.println("[Client] received : "+resp);
			
			System.out.println("[Client] done");
			
			//�� �ڵ常 ���������� ����Ұ�, ��ȭ������밡 ������̾����
		} catch (IOException e) {
			System.out.println("[Client] socket error"+e.toString());
		}
	}
}
