import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Source04_Network_Server {
	public static void main(String[] args) {
		try {
			System.out.println("[Server] starting");
			
			// Ŭ�󿡼� �߻��� Socket�� ����� Socket ��üȮ����
			// Ŭ���ʰ��� ���� �ٸ� �۾����� �ؾ� �Ѵ�.
			// (��ȭ�� �޴� ��Ȳ�� �����ؾ� �ϹǷ�)
			// ServerSocket ��ü�� �̿��ؾ� �Ǵµ�, Socket�� connect ��û�� �޾��ִ� ��ü
			
			ServerSocket server = new ServerSocket(56789); // �������� ������ ��Ʈ 
			// connect ���� port�� binding (����ΰ�)
			// inform ��ü : ó�� Ŀ��Ʈ�� �޾Ƽ� ���������� Socket ��ü �������� 
			
			System.out.println("[Server] bind "+server.getLocalPort());
			// �� ��ü�� �����ߴٰ� �ؼ� �����û�� �� �޴°� �ƴϰ�,
		//	server.accept(); // �ش� port�� ������ socket�� connect�� ��ٸ�
			// -> �����¼���, return type Socket
								
			Socket socket = server.accept();
			// ����� ����� Socket ��üȮ�� �Ǹ�
			System.out.println("[Server] connected by opposite...");
			System.out.println("[Server] local : "+socket.getLocalAddress());
			// ������ ��Ʈ
			System.out.println("[Server] remote : "+socket.getRemoteSocketAddress());
			// Ŭ���̾�Ʈ�� ��Ʈ
			
			// �ݴ������� write ��ų�� DataOuput���� write ��Ű�� ������
			// ���ʿ��� ������ input�� DataInput���� �ؾ߸� �ǹ��ְ� ����			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// �ݴ������� ���� byte�� DataIn���� ó���ϱ� ������,
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			// ������ �Է°� ������ ���, �� �ݴ븦 ���� ������� ��������Ű���
			
			String req = dis.readUTF();
			System.out.println("[Server] received : "+req);
			String resp = "success";
			dos.writeUTF(resp);
			System.out.println("[Server] send : " +resp);
			
		} catch (IOException e) {
			System.out.println("[Server] main error " + e.toString());
		}
	}
}
