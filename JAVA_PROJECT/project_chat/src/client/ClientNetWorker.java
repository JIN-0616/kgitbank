package client;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ClientNetWorker extends Thread {
	ClientUI ui;
	
	Socket socket;  // TCP �� ���� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;  // UDP �������(���ú��)
	
	public ClientNetWorker(String ip, ClientUI ui) {
		this.ui = ui;
		try {
			socket = new Socket(ip, 56789);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
			dataSocket = new DatagramSocket(socket.getLocalSocketAddress());
			start();
		} catch(IOException e) {
			System.out.println("[client] network error");
			JOptionPane.showMessageDialog(ui, "��Ʈ��ũ����\n���� ������ �Դϴ�");
			throw new RuntimeException();
		}
	}
	
	public void sendJoinRequest(String nick, String pass, String hint) {
		try {
			synchronized(oos) {
				String req = "join#"+nick+"#"+pass+"#"+hint;
				oos.writeObject(req);
				Boolean resp = (Boolean)ois.readObject();
				if(resp) {
					JOptionPane.showMessageDialog(ui, "���� �����Դϴ�");
					// ui.setContentPane(ui.LoginPanel);
					// ui.pnLogin.... setText(id);
				} else {
					JOptionPane.showMessageDialog(ui, "���� ����\n�̹� �ִ� ���̵� �Դϴ�.");
				}
			}
		} catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� �����Դϴ�");
		}
	}
	
	public void sendAuthRequest(String nick, String pass) {
		try {
			synchronized(oos) {
				String req = "auth#" + nick + "#" + pass;
				oos.writeObject(req);
				Boolean resp = (Boolean)ois.readObject();
				if(resp) {
					Rectangle r = ui.getBounds();
					r.grow(100, 100);
					ui.setBounds(r);
					// �α��� ������ ui������ ��
					ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
					ui.setTitle("kakaotalk");
				} else {
					// �α��� ���� ��Ȳ.
					// ��Ÿ��Ʋ�� �󺧿� "���̵� �Ǵ� ��й�ȣ�� �ٽ� Ȯ���� �ּ���." ������
				}
			}
		} catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "���� ��� �����Դϴ�");
		}
	}
	
	public void sendNewJoinRequest() {
		ui.setContentPane(ui.pnJoin);
		ui.setTitle("ȸ������");	
	}
	
	public void run() { // ���������κ��� �ҽÿ� ���޹ްԵ� UDP
		while(!dataSocket.isClosed()) {
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024],1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received : " + alram);
				switch(alram) {
				case "newChat":
					
					break;
				}
				
			} catch(IOException e) {
				dataSocket.close();
				break;
			}
		}
	}

}
