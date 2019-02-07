import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 * 네트워크를 이용해서 데이터를 전송하는 방식은
 *  UDP와 TCP 두가지가 있다고 했는데,
 *  DatagreamSocket, DatagreamPacket을 이용한 UDP 교환을 먼저 학습하였다.
 *  
 * 이번에는 TCP 방식의 교환을 하고자 할때 사용하는
 *  Socket, ServerSocket 객체에 대해 알아보자.
 *   
 */
public class Source04_Network_Client {
	public static void main(String[] args) {
		/*
		 * TCP 방식은 UDP와 다르게 데이터 교환을 위해서 
		 * 일단 통신하고자 하는 상대방과 선 연결이 되어야 한다.
		 * 
		 * 지금 살펴볼 코드는 서버측과 연결하여 데이터를 보낸후 응답을 받는 작업이다.
		 */
		
		try {
						  //new Socket(targetIP, targetPort);
			Socket socket = new Socket("192.168.10.155", 56789); // 상대방측을 지정(전화를 거는것) 
			// 소캣객체 생성은 한가지만 있는건 아니지만,
			// 주 생성은 연결하고자 하는 대상의 ip(String)와 port(int)를 지정하면서 생성시킨다.  	
			// 이 객체를 이용해서 통신이 진행된다.
			// Socket은 UDP의 DatagreamSocket 객체와는 다르게, 상대방과 1:1로 연결이 유지되는 객체이다.
			// 객체 생성에 성공하게 되면, 상대방과 연결이 됬다는 것!			
			System.out.println("[Client] connect to opposite in "+socket.getLocalPort());
			// 자신의 포트는 남는 포트가 사용됨
			// 연결이 되고 나면, UDP 보다 더 쉬울수도 있다.
			// socket 객체에서 상대방측과 io stream 객체가 만들어지는데,
			InputStream is = socket.getInputStream();	// 상대방이 보낸걸 받는 객체
			OutputStream os = socket.getOutputStream(); // 상대방에게 보낼때 사용하는 객체
			
			/*
			 * TCP는 In, Out을
			 *  Data in,out | Object in,out | BufferedReader, BufferedWriter
			 *  PrintWriter, Scanner 로 변경시켜 데이터를 교환할 수 있다.
			 *  
			 *  예를 들어 DataIn,Out을 이용해서 교환을 해보자
			 */
			
			DataOutputStream dos = new DataOutputStream(os);
			DataInputStream dis = new DataInputStream(is);
			String req = "join#saan#1q2w3e4r#윤형호";
			dos.writeUTF(req);
			String resp = dis.readUTF();			
			System.out.println("[Client] received : "+resp);
			
			System.out.println("[Client] done");
			
			//이 코드만 독립적으로 실행불가, 전화받을상대가 대기중이어야함
		} catch (IOException e) {
			System.out.println("[Client] socket error"+e.toString());
		}
	}
}
