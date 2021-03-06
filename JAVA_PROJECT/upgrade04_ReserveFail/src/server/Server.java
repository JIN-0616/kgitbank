package server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Server {
	public static void main(String[] args) {
		System.out.println("[server] started");
		try {
			ServerSocket sc = new ServerSocket(56789);
			Socket soc =sc.accept();
			System.out.println("[server] init....");
			System.out.println("[server] connected from "+soc.getLocalAddress());
			System.out.println("[server] connected to "+soc.getRemoteSocketAddress());
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
			System.out.println("[server] established i/o stream");
			Set<String> set = new HashSet();
				set.add("1-A");
				set.add("1-B");
			while(soc.isConnected()) {
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
					break;
				default:
					rst += "error";
					break;
				}				
				oos.writeObject(rst);
				System.out.println("[server] send "+rst);
			}
			sc.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("[server] network error"+e.toString());
		}
	}
}
