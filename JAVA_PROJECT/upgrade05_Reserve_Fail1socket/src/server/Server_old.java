package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server_old {
	public static void main(String[] args) {
		System.out.println("[server] started");
		Set<String> set = new HashSet();
			set.add("1-A");
			set.add("1-B");
		try {
			ServerSocket sc = new ServerSocket(56789);
			
			//사용자 접속종료후 다른사용자 접속을 위한 구조
			while(!sc.isClosed()) {
				Socket soc =sc.accept();
				System.out.println("[server] init....");
				System.out.println("[server] connected from "+soc.getLocalAddress());
				System.out.println("[server] connected to "+soc.getRemoteSocketAddress());
				ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
				System.out.println("[server] established i/o stream");
				while(soc.isConnected()) {
			//  while(!soc.isClosed()){
					String resp = (String)ois.readObject();
					System.out.println("[server] client request "+resp);
					String[] a = resp.split("#");
					String rst = "";
					switch (a[0]) {
					case "reserve":
						if(!set.contains(a[1])) {
							set.add(a[1]);
							rst += "true";
						}else {
							rst += "false";
						}
						break;
					case "cancel":
						if(set.contains(a[1])) {
							set.remove(a[1]);
							rst += "true";
						}else {
							rst += "false";
						}					
						break;
					case "total":
						for (Iterator i = set.iterator(); i.hasNext();) {
							String s = (String) i.next();
							rst += s;
							if (i.hasNext()) {
								rst += "#";
							}
						}
						//rst = seats.toString().replace("[","").replace("]","").replace(" ","").replace(",","#");
						break;
					default:
						rst += "error";
						break;
					}				
					oos.writeObject(rst);
					System.out.println("[server] send "+rst);
				}
				System.out.println("[server] disconnect  : " + soc.getRemoteSocketAddress());
			}
			sc.close();
		} catch (IOException | ClassNotFoundException e) {
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
