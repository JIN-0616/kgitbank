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
	
	Socket socket;	// �� �ٽɿ��� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;	// ������� (���ú��)
	
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
			JOptionPane.showMessageDialog(ui, "��Ʈ��ũ����\n������ �����̴�.");
			throw new RuntimeException();
		}
	}
	
	/* 
	 *  ������ ��û�� ������ ����� �͵��� �̸� �� ����� �Ѱ�.
	 * ������ �̺�Ʈ�����ʷ� �ѱ��� ����, �޾Ƽ� ���⼭ ó��. 
	 */
	// #������ ��û# : ����� ��������鼭 ���� ��.
	public void sendEnterRequest(int idx) {
		try {
			String req = "enter#"+idx;
			oos.writeObject(req);
			Room r = (Room)ois.readObject();
			
			if(r == null) {
				JOptionPane.showMessageDialog(ui, "������/���� ������");
			}else {
				ui.setContentPane(ui.pnRoom);
				ui.pnRoom.lbRoom.setText(r.toString());
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	
	
	
	// #���� ��û#
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
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
		
	}
	
	
	// #�޼��� �����û#
	public void sendChatRequest(String msg) {
		try {
			String req ="chat#"+msg;
			oos.writeObject(req);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	// #�޼��� ��Ͽ�û#
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
			int n = ui.pnLounge.taLog.getCaretPosition();	// Ŀ�� ��ġ
			ui.pnLounge.taLog.setCaretPosition(txt.length());
			
			
			
			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	
	
	
	
	// # ���� ��û #
	public void sendJoinRequest(String nick, String pass) {
		try {
			String req ="join#"+nick+"#"+pass;
			oos.writeObject(req);
			Boolean resp = (Boolean)ois.readObject();
			if(resp) {
				JOptionPane.showMessageDialog(ui, "���� �����̴�.");
				ui.pnWelcome.tabbedPane.setSelectedIndex(0);
				ui.pnWelcome.tfAuthNick.setText(nick);
				
			}else {
				JOptionPane.showMessageDialog(ui, "���� ���д�.\n�̹� �ִ� �г����̴�.");
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
		
	}
	
	
	// # �α��� ���� ��û #
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
				
				ui.setTitle("��"+nick + ", �α׿¡� - B i n g o");	
				
				sendUserListRequest();
				sendRoomListRequest();
			}else {
				JOptionPane.showMessageDialog(ui, "���� ���д�.\n���̵� �Ǵ� ��й�ȣ ����ġ��.");
			}
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	
	public void sendUserListRequest() {
		try {
			String req ="all";
			oos.writeObject(req);
			/*
				Object[] ar = (Object[])ois.readObject();
				ui.pnLounge.liUser.setListData(ar);	// List�� �����͸� �����ϴ� ���
			*/
			List resp = (List)ois.readObject();
			Vector vc = new Vector<>();
			vc.addAll(resp);	// ��� ���޹����� Vector�⿡ �ٷ� ĳ�����ؼ� ó���߾ �ȴ�.
			
			ui.pnLounge.liUser.setListData(vc);	// List�� �����͸� �����ϴ�
			
			/*
			Object[] ar =  new Object[] {"������","��ŷ"};
			Vector vc = new Vector();
				vc.add("������");
				vc.add("ȫ�浿");
				vc.add("���ǽ�����");
			*/
			
		}catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	
	public void sendExitRequest() {
		try {
			String req ="exit";
			oos.writeObject(req);
			socket.close();
			System.exit(0);
		}catch(IOException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� ������");
		}
	}
	
	
	
	
	
	// ���������κ��� �ҽÿ� ���޹ްԵ� �˸���Ŷ�� ó���ϴ� �κ�
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
