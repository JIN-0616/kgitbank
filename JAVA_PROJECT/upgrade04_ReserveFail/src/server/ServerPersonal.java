package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ServerPersonal extends Thread {
	// commons==========================================================
	static List<String> seats;	
	static List<ServerPersonal> managers;	
	static {
		seats = new ArrayList<>();
		seats.add("1-A");
		seats.add("1-B");
		managers = new ArrayList<>();
	}	
	// individual=======================================================
	Socket soc;
	ObjectOutputStream oos; 
	ObjectInputStream ois;
	
	// 밖에서 선언하고 생성은 생성자 안에서 하도록 유도

	public ServerPersonal(Socket soc) {
		this.soc = soc;
		try {
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
			managers.add(this); // 생성되면 자신을 저장
			
		} catch (IOException e) {
			System.out.println("[server"+getName()+"] socket network error");
			
		}
		
	}
	@Override
	public void run() {
		System.out.println("[server] established i/o stream");
		while(soc.isConnected()) {		//  while(!soc.isClosed()){
			String resp;
			try {
				resp = (String)ois.readObject();	// 필수 try~catch 코드
			} catch (IOException | ClassNotFoundException e) {
				managers.remove(this);
				break;
			}
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
			try {
				// 필요에 따라 아래 두 문을 선택해서 보내주는 코드를 선택
				
				// 1. 당사자한테만
				// this.oos.writeObject(resp);				
				
				// 2. 공통 답변 보내기 (원래는 선별 따라서 잘못됨) 
				for(ServerPersonal p : managers) {
					p.oos.writeObject(resp);	
				}
				System.out.println("[server-"+getName()+"] sent respons : " +rst);
			} catch(IOException e){
				managers.remove(this);
				break;
			}
		}
		System.out.println("[server-"+getName()+"] disconnect  : " + soc.getRemoteSocketAddress());
	}
}