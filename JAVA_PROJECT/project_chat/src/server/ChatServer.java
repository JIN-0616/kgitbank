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
	static List<Account> connectors;		//구조상 필요한가의 문제
	static List<Message> chatLog;		
	static List<Room> rooms;				
	
	static {
		try {
			FileInputStream fis = new FileInputStream("account.data");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			allAccounts = (Hashtable)ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("파일 입력 에러");
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
			case "chat":		 // 채팅내용, 방번호변수
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
			case "leave":				// 방번호가 변수로 들어가게
				roomLeaveHandle(rooms.get(Integer.valueOf(reqs[1])));
				break;
			case "myRoom":		// 방번호가 변수로 들어가게
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
				sendRepsonse(f+"친구등록완료");				
			}else {
				sendRepsonse("찾을수 없습니다.");
			}			
		}
		
		private void removeFriendHandle(String f) {
			if(allAccounts.containsKey(f)) {
				onUser.friendSub(allAccounts.get(f));
				sendRepsonse(f+"친구삭제완료");
			}else {
				sendRepsonse("찾을수 없습니다.");
			}
			
		}
		
		//--------------전체 채팅내용 ---> 방 채팅으로 변경할것-----------------------
		private void chatLogRequestHandle() {	// 시간대 이후의 채팅기록을 가져오는것? 필요한가?		
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
			
			// 채팅로그는 그냥 기록해도 된다. 파일출력
			
			// 방별로 채팅로그를 기록하는가
			// 아니면 전체 채팅 로그를 기록하는가에 따라 구조가 달라짐
						
			// account의 친구목록의 경우에는 매번 read해야되는 경우임
					
			// GUI를 종료하고 로그아웃한 이후 다시 로그인 하였을때
			// 기존의 채팅내용까지 모두 다시 불러내야하는가?
			
			try {
				FileOutputStream fos = new FileOutputStream(s); 
				ObjectOutputStream oos = new ObjectOutputStream(fos);	 
				
				oos.writeObject(allAccounts);
				System.out.println("try success! output ready!");
					
				oos.close();				
				
			} catch (IOException e) {
				System.out.println("파일출력에러");
			}
			
			connectors.remove(onUser);			
			this.stop();
		}
}
