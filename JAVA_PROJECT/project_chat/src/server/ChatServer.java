package server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.Account;
import common.Message;
import common.Room;

public class ChatServer extends Thread{
	//--static---------------------------------------------------------------------------------------
	static DatagramSocket alramSocket;  
	static Map<String,Account> allAccounts;		
	static List<Account> connectors;		//������ �ʿ��Ѱ��� ����
	static List<Message> chatLog;		
	static List<Room> rooms;				
	
	static {
		try {
			FileInputStream fis = new FileInputStream("account.data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			allAccounts = (Hashtable)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("���� �Է� ����");
		}
		
//		allAccounts = new Hashtable<>();	
//			allAccounts.put("admin", new Account("admin", "admin"));
//			allAccounts.put("test1", new Account("test1", "test1"));
//			allAccounts.put("test2", new Account("test2", "test2"));
//			allAccounts.put("test3", new Account("test3", "test3"));
//			allAccounts.put("test4", new Account("test4", "test4"));

		connectors = new Vector<>();
		chatLog = new Vector<>();
		rooms = new ArrayList<>();			
			
		try {
			alramSocket = new DatagramSocket(56789);	
		} catch (IOException e) {
			System.out.println("alramSocket create fail "+e.toString());
		}		
	}
	
	static void sendAlramToRoom(String alram, Room r) {
		List<SocketAddress> sock = new ArrayList<>();
		for (int i = 0; i < r.joiner.size(); i++) {
			sock.add(r.joiner.get(i).getSock());
			
		}
		DatagramPacket p = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
		for (SocketAddress sa : sock) {
			p.setSocketAddress(sa);
			try {
				alramSocket.send(p);				
			} catch (IOException e) {
				System.out.println("[sever-Thread] send alarm failed target "+ sa);
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
	Socket socket;
	ObjectInputStream ois; 
	ObjectOutputStream oos;
	
	Account onUser; 
	long accessTime;
	int idx;
	
	ChatServer(Socket soc) {		
		socket =soc;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			System.out.println("[server-"+getName()+"] socket ready " + soc.getRemoteSocketAddress());
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
				connectors.remove(onUser);
				break;
			}
			System.out.println("[server-"+getName()+"] received request : " + req);
			String[] reqs = req.split("#"); 			
			switch (reqs[0]) {
			case "join":		
				joinRequestHandle(reqs[1],reqs[2]);
				break;
			case "auth":				
				authRequestHandle(reqs[1], reqs[2]);
				break;
			case "all":				
				allRequestHandle();
				break;
			case "exit":
				exitRequestHandle();
				break;
			case "chat":		 // ä�ó���, ���ȣ����
				chatRequestHandle(reqs[1],rooms.get(Integer.valueOf(reqs[2])));
				break;
			case "chatLog":
				chatLogRequestHandle();
				break;
			case "roomList":
				roomListReqiestHandle();
				break;
			case "enter":
				roomMakeEnterHandle();				
				break;
			case "leave":				// ���ȣ�� ������ ����
				roomLeaveHandle(rooms.get(Integer.valueOf(reqs[1])));
				break;
			case "myRoom":		// ���ȣ�� ������ ����
				roomInfoHandle(Integer.valueOf(reqs[1]));
				break;
			case "find":
				findFriendHandle(reqs[1]);
				break;
			case "remove":
				removeFriendHandle(reqs[1]);
				break;
			default:
				
			}
		}
		System.out.println("[server-"+getName()+"] disconnect  : " + socket.getRemoteSocketAddress());
	}
	
		private void roomInfoHandle(int roomNum) {			
			sendRepsonse(rooms.get(roomNum));
		
		}
		private void roomLeaveHandle(Room r) {							
			sendRepsonse(rooms.get(r.idx).leaved(onUser));
			if(rooms.get(r.idx).isEmpty()) {
				rooms.remove(r.idx);
			}			
			sendAlramToRoom("refresh",rooms.get(r.idx));			
		}


		private void roomMakeEnterHandle() {
			Room nowRoom = new Room(onUser);
			rooms.add(nowRoom);
			sendRepsonse(nowRoom);			
			onUser.roomNum.add(rooms.indexOf(nowRoom));
			nowRoom.idx = rooms.indexOf(nowRoom);			
						
		}

		private void roomListReqiestHandle() {			
			sendRepsonse(rooms);	
			
		}

		private void findFriendHandle(String f) {
			if(allAccounts.containsKey(f)) {
				onUser.friendAdd(allAccounts.get(f));
				sendRepsonse(f+"ģ����ϿϷ�");				
			}else {
				sendRepsonse("ã���� �����ϴ�.");
			}			
		}
		
		private void removeFriendHandle(String f) {
			if(allAccounts.containsKey(f)) {
				onUser.friendSub(allAccounts.get(f));
				sendRepsonse(f+"ģ�������Ϸ�");
			}else {
				sendRepsonse("ã���� �����ϴ�.");
			}
			
		}
		
		//--------------��ü ä�ó��� ---> �� ä������ �����Ұ�-----------------------
		private void chatLogRequestHandle() {	// �ð��� ������ ä�ñ���� �������°�? �ʿ��Ѱ�?		
			List<Message> timeLog = new Vector<>();
			for (Message m : chatLog) {
				if(accessTime<m.getTime()) {
					timeLog.add(m);
				}
			}
			sendRepsonse(timeLog);				
		}
		private void chatRequestHandle(String log, Room r) {
			chatLog.add(new Message(onUser.getNick(), log));
			sendAlramToRoom("newChat",r);	
		}
		//-------------------------------------------------------------------------------------

		private void sendRepsonse(Object obj) {
			try {
				synchronized (oos) {					
					oos.reset(); 			
					oos.writeObject(obj);
				}
			}catch(IOException e) {
				System.out.println("[server-" + getName() + "] i/o error  : " + e.toString());
				connectors.remove(onUser);
				stop();
			}
		}		
	
		
		
		//=====================================================================
		private void allRequestHandle() {	
			sendRepsonse(connectors);		
		}

		private void authRequestHandle(String nick, String pass) {
			if(allAccounts.containsKey(nick) 
					&& allAccounts.get(nick).getPass().equals(pass)) {
				if(!connectors.contains(allAccounts.get(nick))) {
					sendRepsonse(true);
					onUser.setSock(socket.getRemoteSocketAddress());
					
					onUser = allAccounts.get(nick);
					accessTime = System.currentTimeMillis();
					connectors.add(onUser);				
					idx = chatLog.size();										
				}else {
					sendRepsonse(false);
				}
			}else {
				sendRepsonse(false);
			}
		}

		private void joinRequestHandle(String nick, String pass) {
			if(allAccounts.containsKey(nick) ) {
				sendRepsonse(false);
			}else {
				allAccounts.put(nick, new Account(nick, pass));
				sendRepsonse(true);
			}
		}
		
		private void exitRequestHandle() {
			File f = new File("chatlog.data");
			File s = new File("account.data");
			
			// ä�÷α״� �׳� ����ص� �ȴ�. �������
			
			// �溰�� ä�÷α׸� ����ϴ°�
			// �ƴϸ� ��ü ä�� �α׸� ����ϴ°��� ���� ������ �޶���
						
			// account�� ģ������� ��쿡�� �Ź� read�ؾߵǴ� �����
					
			// GUI�� �����ϰ� �α׾ƿ��� ���� �ٽ� �α��� �Ͽ�����
			// ������ ä�ó������ ��� �ٽ� �ҷ������ϴ°�?
			
			try {
				FileOutputStream fos = new FileOutputStream(s); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);	 
				
				oos.writeObject(allAccounts);
				System.out.println("try success! output ready!");
					
				oos.close();				
				
			} catch (IOException e) {
				System.out.println("������¿���");
			}
			
			connectors.remove(onUser);			
			this.stop();
		}
}
