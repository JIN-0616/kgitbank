import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Source04_Network_Server {
	public static void main(String[] args) {
		try {
			System.out.println("[server] starting");

			// Ŭ�󿡼� �߻��� Socket�� ����� Socket ��üȮ����..? 
			// Ŭ�������� ���� �ٸ� �۾����� �ذ��ؾ� �Ѵ�.
			// ServerSocket ��ü�� �̿��ؾ� �Ǵµ�, Socket�� connect ��û�� �޾��ִ� ��ü
			ServerSocket server = new ServerSocket(56789);	// �������� ������ ��Ʈ
			// connect ���� port�� binding (����ΰ�)
			System.out.println("[server] bind at " +server.getLocalPort());
			// �� ��ü�� �����ߴٰ� �ؼ� ������ �� �޴°� �ƴϰ�, 
		// 	server.accept();	// �ش� port �� ������ socket�� connect�� ��ٸ�. 
			
			Socket socket = server.accept();	// ����� ����� Socket ��üȮ�� �Ǹ�
			System.out.println("[server] connected by opposite..");
			System.out.println("[server] local : " + socket.getLocalSocketAddress());
			System.out.println("[server] remote : " + socket.getRemoteSocketAddress());
			
			// �ݴ������� write ��ų�� DataOutput ���� write ��Ű�� ������
			// ���ʿ��� ������ input�� DataInput ���� �ؾ߸� �ǹ��ֱ� ����.
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// �ݴ������� �޴� byte�� DataIn���� ó���ϱ� ������,
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			
			String req = dis.readUTF();
			System.out.println("[server] received : " + req);
			String resp = "success";
			dos.writeUTF(resp);
			System.out.println("[server] send : "+ resp);
			
			
			
		}catch(IOException e) {
			System.out.println("[server] main error : " + e.toString());
		}
	}
}




















