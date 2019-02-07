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
			 *  ����ڰ��� ���������� ��ߵǴ� ��ü�� ������,
			 *  �̰� ���ξ����忡�� �� ������ ���� �Ѱ���� �ϳ�?
			 *  
			 *  ����� �ȱ׷��� �ȴ�.
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
			
			//����� ���������� �ٸ������ ������ ���� ����
			while(!sc.isClosed()) {
				Socket soc =sc.accept(); // ������� �ѱ�� �ȵ�
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
			ServerSocket server = new ServerSocket(56789); // �������� ������ ��Ʈ
			long t2 = System.currentTimeMillis();
			System.out.println("[server] startup in " + (t2 - t1) + " ms");

			while (!server.isClosed() ) {
				Socket socket = server.accept(); //
				System.out.println("[server] connected by " + socket.getRemoteSocketAddress());
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

				while (!socket.isClosed()) { // ��������ڸ� �ޱ����ؼ�! �ݺ��ؾ��� ����
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
