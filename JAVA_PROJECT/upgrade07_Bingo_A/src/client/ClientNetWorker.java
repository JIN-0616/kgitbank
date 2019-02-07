package client;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import common.Message;
import common.Room;

public class ClientNetWorker extends Thread{
	ClientUI ui;
	
	Socket socket;	// 주 핵심연결 소켓
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// 서브소켓 (리시브용)
	
	public ClientNetWorker(String ip, ClientUI ui) {
		this.ui = ui;
		try {
			socket = new Socket(ip, 56789);
			oos = new ObjectOutputStream(socket.getOutputStream());	
			ois = new ObjectInputStream(socket.getInputStream());
			
			dataSocket = new DatagramSocket(socket.getLocalPort());	
			start();
		} catch (IOException e) {
			System.out.println("[client] network error");
			JOptionPane.showMessageDialog(ui, "네트워크오류\n서버측 점검이다.");
			throw new RuntimeException();
		}
	}
	
	/* 
	 *  서버로 요청을 보낼때 사용할 것들을 미리 다 만들어 둘것.
	 * 응답을 이벤트리스너로 넘기지 말고, 받아서 여기서 처리. 
	 */
	// #방입장 요청# : 빈방은 만들어지면서 입장 됨.
	public void sendEnterRequest(int idx) {
		try {
			String req = "enter#"+idx;
			oos.writeObject(req);
			Room r = (Room)ois.readObject();
			
			if(r == null) {
				JOptionPane.showMessageDialog(ui, "방입장/생성 오류다");
			}else {
				ui.setContentPane(ui.pnRoom);
				ui.pnRoom.lbRoom.setText(r.toString());
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	
	
	
	// #방목록 요청#
	public void sendRoomListRequest() {
		try {
			String req = "roomList";
			oos.writeObject(req);
			Room[] ar = (Room[])ois.readObject();
			for(int i=0; i<ar.length; i++) {
				System.out.println(i+" = " + ar[i]);
				JButton bt = ui.pnLounge.rbts.get(i);
				if(ar[i] != null) {
					bt.setText(ar[i].toString());
					if(ar[i].joiner.size()==2) {
						bt.setEnabled(false);
					}else {
						bt.setEnabled(true);
					}
				}else {
					bt.setText("");
					bt.setEnabled(true);
				}
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
		
	}
	
	
	// #메세지 저장요청#
	public void sendChatRequest(String msg) {
		try {
			String req ="chat#"+msg;
			oos.writeObject(req);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	// #메세지 목록요청#
	public void sendChatLogRequest() {
		try {
			String req ="chatLog";
			oos.writeObject(req);
			List<Message> li = (List)ois.readObject();
			String txt="";
			for(Message m : li) {
				txt += m.toString() +"\n";
			}
			ui.pnLounge.taLog.setText(txt);
			int n = ui.pnLounge.taLog.getCaretPosition();	// 커서 위치
			ui.pnLounge.taLog.setCaretPosition(txt.length());
			
			
			
			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	
	
	
	
	// # 가입 요청 #
	public void sendJoinRequest(String nick, String pass) {
		try {
			String req ="join#"+nick+"#"+pass;
			oos.writeObject(req);
			Boolean resp = (Boolean)ois.readObject();
			if(resp) {
				JOptionPane.showMessageDialog(ui, "가입 성공이다.");
				ui.pnWelcome.tabbedPane.setSelectedIndex(0);
				ui.pnWelcome.tfAuthNick.setText(nick);
				
			}else {
				JOptionPane.showMessageDialog(ui, "가입 실패다.\n이미 있는 닉네임이다.");
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
		
	}
	
	
	// # 로그인 인증 요청 #
	public void sendAuthRequest(String nick, String pass) {
		try {
			String req ="auth#"+nick+"#"+pass;
			oos.writeObject(req);
			Boolean resp = (Boolean)ois.readObject();
			if(resp) {
				Rectangle r = ui.getBounds();
				r.grow(100, 100);
				ui.setBounds(r);
				ui.setContentPane(ui.pnLounge);
				ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
				ui.setTitle("〔"+nick + ", 로그온〕 - B i n g o");	
				
				sendUserListRequest();
				sendRoomListRequest();
			}else {
				JOptionPane.showMessageDialog(ui, "인증 실패다.\n아이디 또는 비밀번호 불일치다.");
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	
	public void sendUserListRequest() {
		try {
			String req ="all";
			oos.writeObject(req);
			/*
				Object[] ar = (Object[])ois.readObject();
				ui.pnLounge.liUser.setListData(ar);	// List에 데이터를 설정하는 방법
			*/
			List resp = (List)ois.readObject();
			Vector vc = new Vector<>();
			vc.addAll(resp);	// 사실 전달받은게 Vector기에 바로 캐스팅해서 처리했어도 된다.
			
			ui.pnLounge.liUser.setListData(vc);	// List에 데이터를 설정하는
			
			/*
			Object[] ar =  new Object[] {"관리자","모킹"};
			Vector vc = new Vector();
				vc.add("관리자");
				vc.add("홍길동");
				vc.add("원피스덕후");
			*/
			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	
	public void sendExitRequest() {
		try {
			String req ="exit";
			oos.writeObject(req);
			socket.close();
			System.exit(0);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	
	
	
	
	
	// 서버측으로부터 불시에 전달받게될 알림패킷을 처리하는 부분
	public void run() {
		while(!dataSocket.isClosed()) {
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received : " +alram );
				switch(alram) {
				case "changeRooms":
					sendRoomListRequest();	break;
				case "changeUsers":
					sendUserListRequest();	break;
				case "newChat":
					sendChatLogRequest();	break;
				}
			}catch(IOException e) {
				dataSocket.close();
				break;
			}
		}
	}

}
