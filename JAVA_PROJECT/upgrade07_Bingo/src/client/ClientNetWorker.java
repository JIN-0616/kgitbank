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
	
	Socket socket;				//�� �ٽɿ��� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// ������� (���ú��)
	
	
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
			JOptionPane.showMessageDialog(ui, "��Ʈ��ũ����\n������ �����̴�.");
			throw new RuntimeException();
		}
	}
	
	// ������ ��û�� ������ ����� �͵��� �̸� �� ����� �Ѱ�
	
	// ������ �̺�Ʈ�����ʷ� �ѱ��� ����, �޾Ƽ� ���⼭ ó��,
	//  ->������ �Ȱ�ġ�� ���ο��� �ٷ� Ʈ������ ó��, �����ڵ鷯������ ��û��!
	
	// 1. ���� ��û
	public void sendJoinRequest(String nick, String pass) {
		String req = "join#"+nick+"#"+pass;
		Object resp = null;
		try {
			synchronized (oos) {
				oos.writeObject(req);
				System.out.println("[client] join requesting...");
				resp = ois.readObject();
				if((boolean)resp) {
					JOptionPane.showMessageDialog(ui, "���� ����.");
					ui.pnWelcome.tabbedPane.setSelectedIndex(0); // ���� �̵� ���� �޼ҵ� - ���̵�(ȭ���̵�)�� ����� ��
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
	
	// 2. ���� ��û
	public void sendAuthRequest(String nick, String pass) {
		String req = "auth#"+nick+"#"+pass;
		boolean resp ;
		try {
			synchronized (oos) {
				oos.writeObject(req);
				System.out.println("[client] Auth requesting...");			
				resp = (boolean)ois.readObject();
				
				if(resp) {
					Rectangle r = ui.getBounds(); // Rectangle ��ü�� �г��� ũ�⸦ ���� (x,y,h,w)
					r.grow(100,100);
					ui.setBounds(r);
					ui.setContentPane(ui.pnLounge);
					ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
					ui.setTitle("��"+nick + ", �α׿¡� - B i n g o");	
					
					sendUserListRequest();
					sendRoomRequest();
				}else {
					System.out.println("[client] login fail �ߺ���û");
					JOptionPane.showMessageDialog(ui, "login fail");
					//��й�ȣ ���� ���?
				}
				
			}
		}catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(ui, "sendAuthRequest error"+e.toString());
		}
	}

	
	// 3. �����ڸ�� ��û
	public void sendUserListRequest() {
		try {
			synchronized (oos) {
				String req = "all";
				oos.writeObject(req);
				List resp = (List)ois.readObject();				
				Vector vc = new Vector<>(); 
				
				vc.addAll(resp);		// ��� ���޹����� Vector�⿡ �ٷ� ĳ�����ؼ� ó���߾ �ȴ�.
				vc.sort(null);
				ui.pnLounge.liUser.setListData(vc);
				
			}
		//	System.out.println("[client] refrashed");
			
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "sendUserListRequest error"+e.toString());
		}			
		
		/* �� JList�� �����͸� �����ϴ� ��� ��
		==> Object[] Ȥ�� vector�� ����
		--------1�����----------------------
		Object[] ar = new Object[] {"������","��ŷ"};
		ui.pnLounge.liUser.setListData(ar); 		
		--------2�����----------------------
		Vector vc = new Vector(); 					 
			vc.add("������");
			vc.add("ȫ�浿");
		ui.pnLounge.liUser.setListData(vc); 		
		*/
	}
	// 4. ���� ��û
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
	// 5. �޽��� ���� ��û
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
	// 6. ä�÷α� ��û
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
				int n = ui.pnLounge.taLog.getCaretPosition();	// Ŀ�� ��ġ
				ui.pnLounge.taLog.setCaretPosition(txt.length());
				
				
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	// �� �迭 ��û
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
	// �� ���� ��û
	public void sendRoomEnterRequest(int idx) {
		try {
			synchronized (oos) {
				String req ="enter#"+idx;
				oos.writeObject(req);
				Room r = (Room)ois.readObject();
				if (r==null) {
					JOptionPane.showMessageDialog(ui, "����� / ���� ����");
				}else {							
					ui.setContentPane(ui.pnRoom);
					ui.pnRoom.lbRoom.setText(r.toString());					
				}				
			}			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "����� / ���� ����");
		}
	}
	
	// �� ���� ��û
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
					JOptionPane.showMessageDialog(ui, "�� ���� ����");
				}
				
			}
		} catch (IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "�� ���� ����"+e.toString());
		}
	}
	// �� ���� ��û
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
			JOptionPane.showMessageDialog(ui, "�� ������û ����"+e.toString());
		}
	}
	
	
	// ���������κ��� �ҽÿ� ���޹ްԵ� �˸���Ŷ�� ó���ϴ� �κ�
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
