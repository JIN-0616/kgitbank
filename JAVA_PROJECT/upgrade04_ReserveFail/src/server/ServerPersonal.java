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
	
	// �ۿ��� �����ϰ� ������ ������ �ȿ��� �ϵ��� ����

	public ServerPersonal(Socket soc) {
		this.soc = soc;
		try {
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
			managers.add(this); // �����Ǹ� �ڽ��� ����
			
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
				resp = (String)ois.readObject();	// �ʼ� try~catch �ڵ�
			} catch (IOException | ClassNotFoundException e) {
				managers.remove(this);
				break;
			}
			System.out.println("[server] client request "+getName()+" "+resp);
			String[] a = resp.split("#");
			String rst = "";
			switch (a[0]) {
			case "reserve":
				synchronized (ServerMain.list) {	// ��ũ�� ���ɱ�
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
			//�ʼ� try catch ���ϱ���
			try {
				// �ʿ信 ���� �Ʒ� �� ���� �����ؼ� �����ִ� �ڵ带 ����
				
				// 1. ��������׸�
				// this.oos.writeObject(resp);				
				
				// 2. ���� �亯 ������ (������ ���� ���� �߸���) 
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