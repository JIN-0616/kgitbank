import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Source04_Network_Server {
	public static void main(String[] args) {
		try {
			System.out.println("[server] starting");

			// 클라에서 발생한 Socket과 연결된 Socket 객체확보는..? 
			// 클라측과는 조금 다른 작업으로 해결해야 한다.
			// ServerSocket 객체를 이용해야 되는데, Socket의 connect 요청을 받아주는 객체
			ServerSocket server = new ServerSocket(56789);	// 서버에서 개방할 포트
			// connect 받을 port에 binding (묶어두고)
			System.out.println("[server] bind at " +server.getLocalPort());
			// 이 객체를 생성했다고 해서 연결을 다 받는건 아니고, 
		// 	server.accept();	// 해당 port 로 들어오는 socket의 connect를 기다림. 
			
			Socket socket = server.accept();	// 상대방과 연결된 Socket 객체확보 되면
			System.out.println("[server] connected by opposite..");
			System.out.println("[server] local : " + socket.getLocalSocketAddress());
			System.out.println("[server] remote : " + socket.getRemoteSocketAddress());
			
			// 반대측에서 write 시킬때 DataOutput 으로 write 시키기 때문에
			// 이쪽에서 들어오는 input을 DataInput 으로 해야만 의미있기 사용됨.
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			// 반대측에서 받는 byte를 DataIn으로 처리하기 때문에,
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




















