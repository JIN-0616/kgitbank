package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMain {
	public static ArrayList<String> list;
	public static void main(String[] args) {
		System.out.println("[server] started");
		list = new ArrayList<String>();
			list.add("1-A");
			list.add("1-B");
			/*
			 *  사용자간에 공통적으로 써야되는 객체가 있을때,
			 *  이걸 메인쓰레드에서 꼭 일일히 만들어서 넘겨줘야 하나?
			 *  
			 *  결론은 안그래도 된다.
			 *  ---------------------------------------------
			 * 	static List<String> seats;
	
				static {
					seats = new ArrayList<>();
					seats.add("1-A");
					seats.add("4-H");
				}
				
			 *  Socket socket;
				ObjectInputStream ois; 
				ObjectOutputStream oos;
				 ---------------------------------------------

			 */
		try {
			ServerSocket sc = new ServerSocket(56789);
			
			//사용자 접속종료후 다른사용자 접속을 위한 구조
			while(!sc.isClosed()) {
				Socket soc =sc.accept(); // 쓰레드로 넘기면 안됨
				System.out.println("[server] init....");
				
				Thread p = new ServerPersonal(soc);
				p.start();
				
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("[server] network error"+e.toString());
		}
	}
}
/*
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	public static void main(String[] args) {
		List<String> seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("4-H");
		System.out.println("[server] starting");
		long t1 = System.currentTimeMillis();
		try {
			ServerSocket server = new ServerSocket(56789); // 서버에서 개방할 포트
			long t2 = System.currentTimeMillis();
			System.out.println("[server] startup in " + (t2 - t1) + " ms");

			while (!server.isClosed() ) {
				Socket socket = server.accept(); //
				System.out.println("[server] connected by " + socket.getRemoteSocketAddress());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				while (!socket.isClosed()) { // 다음사용자를 받기위해서! 반복해야할 구조
					String req;
					try {
						req = (String) ois.readObject();
					} catch (IOException e) {
						break;
					}
					System.out.println("[server] received request : " + req);
					String[] reqs = req.split("#");
					String resp = null;
					switch (reqs[0]) {
					case "reserve":
						if (seats.contains(reqs[1])) {
							resp = "false";
						} else {
							resp = "true";
							seats.add(reqs[1]);
						}
						break;
					case "cancel":
						if (seats.contains(reqs[1])) {
							resp = "true";
							seats.remove(reqs[1]);
						} else {
							resp = "false";
						}
						break;
					case "all":
						break;
					default:
						resp = "unknown";
					}
					oos.writeObject(resp);
					System.out.println("[server] sent response : " + resp);
				}
				System.out.println("[server] disconnect  : " + socket.getRemoteSocketAddress());
			}
			server.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[server] main error : " + e.toString());
			System.out.println("[server] terminated");
		}

	}
}
*/
