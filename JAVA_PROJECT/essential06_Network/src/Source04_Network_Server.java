import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Source04_Network_Server {
	public static void main(String[] args) {
		try {
			System.out.println("[Server] starting");
			
			// 클라에서 발생한 Socket과 연결된 Socket 객체확보는
			// 클라쪽과는 조금 다른 작업으로 해야 한다.
			// (전화를 받는 상황을 설정해야 하므로)
			// ServerSocket 객체를 이용해야 되는데, Socket의 connect 요청을 받아주는 객체
			
			ServerSocket server = new ServerSocket(56789); // 서버에서 개방할 포트 
			// connect 받을 port에 binding (묶어두고)
			// inform 객체 : 처음 커넥트를 받아서 실질연결할 Socket 객체 생성해줌 
			
			System.out.println("[Server] bind "+server.getLocalPort());
			// 이 객체를 생성했다고 해서 연결요청을 다 받는건 아니고,
		//	server.accept(); // 해당 port로 들어오는 socket의 connect를 기다림
			// -> 대기상태설정, return type Socket
								
			Socket socket = server.accept();
			// 상대방과 연결된 Socket 객체확보 되면
			System.out.println("[Server] connected by opposite...");
			System.out.println("[Server] local : "+socket.getLocalAddress());
			// 서버측 포트
			System.out.println("[Server] remote : "+socket.getRemoteSocketAddress());
			// 클라이언트측 포트
			
			// 반대측에서 write 시킬때 DataOuput으로 write 시키기 때문에
			// 이쪽에서 들어오는 input을 DataInput으로 해야만 의미있게 사용됨			
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// 반대측에서 받은 byte를 DataIn으로 처리하기 때문에,
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			// 상대방의 입력과 이쪽의 출력, 그 반대를 서로 맞춰줘야 데이터통신가능
			
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
