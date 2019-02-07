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

import common.Account;
import common.Message;
import common.Room;

public class ClientNetWorker extends Thread {
	ClientUI ui;
	
	Socket socket;				//주 핵심연결 소켓
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// 서브소켓 (리시브용)
	
	
	public ClientNetWorker(String ip, ClientUI ui) {
		this.ui=ui;
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
	
	// 서버로 요청을 보낼때 사용할 것들을 미리 다 만들어 둘것
	
	// 응답을 이벤트리스너로 넘기지 말고, 받아서 여기서 처리,
	//  ->리스너 안거치고 내부에서 바로 트렌젝션 처리, 엑션핸들러에서는 요청만!
	
	// 1. 가입 요청
	public void sendJoinRequest(String nick, String pass) {
		String req = "join#"+nick+"#"+pass;
		Object resp = null;
		try {
			synchronized (oos) {
				oos.writeObject(req);
				System.out.println("[client] join requesting...");
				resp = ois.readObject();
				if((boolean)resp) {
					JOptionPane.showMessageDialog(ui, "가입 성공.");
					ui.pnWelcome.tabbedPane.setSelectedIndex(0); // ※탭 이동 설정 메소드 - 탭이동(화면이동)시 사용할 것
					ui.pnWelcome.tfAuthNick.setText(nick);
					ui.pnWelcome.pfAuthPass.setText(pass);
				}else{
					System.err.println("[client] join requesting fail");
				}
			}
			
		}catch (ClassNotFoundException | IOException e) {
			System.err.println("[client] join request recieve response error : "+e.getMessage());
		}				
	}
	
	// 2. 인증 요청
	public void sendAuthRequest(String nick, String pass) {
		String req = "auth#"+nick+"#"+pass;
		boolean resp ;
		try {
			synchronized (oos) {
				oos.writeObject(req);
				System.out.println("[client] Auth requesting...");			
				resp = (boolean)ois.readObject();
				
				if(resp) {
					Rectangle r = ui.getBounds(); // Rectangle 객체로 패널의 크기를 조절 (x,y,h,w)
					r.grow(100,100);
					ui.setBounds(r);
					ui.setContentPane(ui.pnLounge);
					ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
					ui.setTitle("〔"+nick + ", 로그온〕 - B i n g o");	
					
					sendUserListRequest();
					sendRoomRequest();
				}else {
					System.out.println("[client] login fail 중복요청");
					JOptionPane.showMessageDialog(ui, "login fail");
					//비밀번호 리셋 어떻게?
				}
				
			}
		}catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(ui, "sendAuthRequest error"+e.toString());
		}
	}

	
	// 3. 접속자명단 요청
	public void sendUserListRequest() {
		try {
			synchronized (oos) {
				String req = "all";
				oos.writeObject(req);
				List resp = (List)ois.readObject();				
				Vector vc = new Vector<>(); 
				
				vc.addAll(resp);		// 사실 전달받은게 Vector기에 바로 캐스팅해서 처리했어도 된다.
				vc.sort(null);
				ui.pnLounge.liUser.setListData(vc);
				
			}
		//	System.out.println("[client] refrashed");
			
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "sendUserListRequest error"+e.toString());
		}			
		
		/* ※ JList에 데이터를 설정하는 방법 ※
		==> Object[] 혹은 vector만 가능
		--------1번방법----------------------
		Object[] ar = new Object[] {"관리자","모킹"};
		ui.pnLounge.liUser.setListData(ar); 		
		--------2번방법----------------------
		Vector vc = new Vector(); 					 
			vc.add("관리자");
			vc.add("홍길동");
		ui.pnLounge.liUser.setListData(vc); 		
		*/
	}
	// 4. 종료 요청
	public void sendExitRequest() {
		try {
			synchronized (oos) {
				
				String req = "exit";	
				oos.writeObject(req);
				socket.close();
				System.exit(0);
			}
		} catch (IOException e) {
			System.err.println("[client] exit requesting error : "+e.getMessage());
		}
		
	}
	// 5. 메시지 저장 요청
	public void sendChatLog(String log) {
		try {
			synchronized (oos) {
				String str = "chat#" + log;		
				oos.writeObject(str);			
				
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(ui, "[client] chat sending request error : "+e.getMessage());
		}
	}
	// 6. 채팅로그 요청
	public void sendChatLogRequest() {
		try {
			synchronized (oos) {
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
				
				
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류다");
		}
	}
	// 룸 배열 요청
	public void sendRoomRequest() {
		try {
			synchronized (oos) {
				
				String req ="roomList";
				oos.writeObject(req);
				Room[] ar = (Room[])ois.readObject();			
				for (int i = 0; i < ar.length; i++) {
					System.out.println(i+" = "+ ar[i]);
					JButton b = ui.pnLounge.rbts.get(i);
					if (ar[i] != null) {
						ui.pnLounge.rbts.get(i).setText(ar[i].toString());
						//b.setText(ar[i].toString());					
						if(ar[i].joiner.size()==2) {
							b.setEnabled(false);
						}else {
							ui.pnLounge.rbts.get(i).setEnabled(true);
						}						
					}else {
						b.setText("");
						b.setEnabled(true);
					}
				}			
				
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "sendRoomRequest Error");
		}
	}
	// 방 입장 요청
	public void sendRoomEnterRequest(int idx) {
		try {
			synchronized (oos) {
				String req ="enter#"+idx;
				oos.writeObject(req);
				Room r = (Room)ois.readObject();
				if (r==null) {
					JOptionPane.showMessageDialog(ui, "방생성 / 입장 오류");
				}else {							
					ui.setContentPane(ui.pnRoom);
					ui.pnRoom.lbRoom.setText(r.toString());					
				}				
			}			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "방생성 / 입장 오류");
		}
	}
	
	// 방 퇴장 요청
	public void sendRoomLeaveRequest() {
		try {
			synchronized (oos) {				
				String req ="leave";
				oos.writeObject(req);
				boolean b = (boolean)ois.readObject();
				if(b) {
					ui.setContentPane(ui.pnLounge);
					sendUserListRequest();
					sendRoomRequest();
				}else {
					JOptionPane.showMessageDialog(ui, "방 퇴장 오류");
				}
				
			}
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "방 퇴장 오류"+e.toString());
		}
	}
	// 방 정보 요청
	public void sendRoomInfoRequest() {
		try {
			synchronized (oos) {
				String req = "myRoom";
				oos.writeObject(req);
				Room r = (Room)ois.readObject();
				String info = "";				
				if(r.joiner.get(0)!=null) {
					Account user1 = r.joiner.get(0);					
					info += user1.toString();					 
				}
				if(r.joiner.get(1)!=null) {
					info +="\n";
					Account user2 = r.joiner.get(1);
					info += user2.toString();					
				}
				ui.pnRoom.taInfo.setText(info);
				
			}
			
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "방 정보요청 오류"+e.toString());
		}
	}
	
	
	// 서버측으로부터 불시에 전달받게될 알림패킷을 처리하는 부분
	public void run() {
		while(!dataSocket.isClosed()) {			
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received " + alram);
				switch(alram) {
				case "changeUsers" :
					sendUserListRequest(); break;
				case "newChat":
					sendChatLogRequest(); break;
				case "changeRooms":
					sendRoomRequest(); break;
				case "refresh":
					sendRoomInfoRequest(); break;
				}
			} catch (IOException e) {
				dataSocket.close();
				break;
			}
		}
	}


}
