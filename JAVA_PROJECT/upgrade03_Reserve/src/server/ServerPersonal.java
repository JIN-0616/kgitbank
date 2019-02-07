package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Iterator;

public class ServerPersonal extends Thread {
	Socket soc;
	
	public ServerPersonal(Socket soc) {
		this.soc = soc;
	}
	@Override
	public void run() {
		try {
			// 밖에서 선언하고 생성은 생성자 안에서 하도록 유도
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			System.out.println("[server] established i/o stream");
			while(soc.isConnected()) {
		//  while(!soc.isClosed()){
				String resp = (String)ois.readObject();	// 필수 try~catch 코드
				System.out.println("[server] client request "+getName()+" "+resp);
				String[] a = resp.split("#");
				String rst = "";
				switch (a[0]) {
				case "reserve":
					synchronized (ServerMain.list) {	// 싱크로 락걸기
						if(!ServerMain.list.contains(a[1])) {
							ServerMain.list.add(a[1]);
							rst += "true";
						}else {
							rst += "false";
						}
					}					
					break;
				case "cancel":
					synchronized (ServerMain.list) {
						if(ServerMain.list.contains(a[1])) {
							ServerMain.list.remove(a[1]);
							rst += "true";
						}else {
							rst += "false";
						}		
					}
					break;
				case "total":
					for (Iterator i = ServerMain.list.iterator(); i.hasNext();) {
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
				//필수 try catch 이하구문
				oos.writeObject(rst);				
				System.out.println("[server-"+getName()+"] sent respons : " +rst);
				oos.reset();
			}
			System.out.println("[server] disconnect  : " + soc.getRemoteSocketAddress());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[server] network error" +e.toString());
		}
	
	}
}
/* teachers A
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerPersonal extends Thread {
	static List<String> seats;
	
	static {
		seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("4-H");
	}
	
	
	Socket socket;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	ServerPersonal(Socket soc) {
		
	
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("[server-"+getName()+"] socket error " + soc.getRemoteSocketAddress());
			throw new RuntimeException();
		}
	}
	
	
	public void run() {
		while (!socket.isClosed()) {
			String req;
			try {
				req = (String) ois.readObject();
			} catch (IOException|ClassNotFoundException	e) {
				break;
			}
			System.out.println("[server-"+getName()+"] received request : " + req);
			String[] reqs = req.split("#");
			String resp = null;
			switch (reqs[0]) {
			case "reserve":
				synchronized (seats) {
					if (seats.contains(reqs[1])) {
						resp = "false";
					} else {
						resp = "true";
						seats.add(reqs[1]);
					}
				}
				break;
			case "cancel":
				synchronized (seats) {
					if (seats.contains(reqs[1])) {
						resp = "true";
						seats.remove(reqs[1]);
					} else {
						resp = "false";
					}
				}
				break;
			case "all":
				resp = seats.toString().replace("[", "").replace("]", "").replace(" ", "").replace(",", "#");
				break;
			default:
				resp = "unknown";
			}
			
			try {
				oos.writeObject(resp);
				System.out.println("[server-"+getName()+"] sent response : " + resp);
			}catch(IOException e) {
				break;
			}
		}
		System.out.println("[server-"+getName()+"] disconnect  : " + socket.getRemoteSocketAddress());
	}
}

*/