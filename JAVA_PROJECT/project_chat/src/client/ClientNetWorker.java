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
	
	Socket socket;  // TCP 주 연결 소켓
	ObjectOutputStream oos;
	ObjectInputStream ois;
	
	DatagramSocket dataSocket;  // UDP 서브소켓(리시브용)
	
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
			JOptionPane.showMessageDialog(ui, "네트워크오류\n서버 점검중 입니다");
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
					JOptionPane.showMessageDialog(ui, "가입 성공입니다");
					// ui.setContentPane(ui.LoginPanel);
					// ui.pnLogin.... setText(id);
				} else {
					JOptionPane.showMessageDialog(ui, "가입 실패\n이미 있는 아이디 입니다.");
				}
			}
		} catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류입니다");
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
					// 로그인 성공후 ui설정할 것
					ui.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					
					ui.setTitle("kakaotalk");
				} else {
					// 로그인 실패 상황.
					// 셋타이틀로 라벨에 "아이디 또는 비밀번호를 다시 확인해 주세요." 넣을것
				}
			}
		} catch(IOException | ClassNotFoundException e) {
			JOptionPane.showMessageDialog(ui, "서버 통신 오류입니다");
		}
	}
	
	public void sendNewJoinRequest() {
		ui.setContentPane(ui.pnJoin);
		ui.setTitle("회원가입");	
	}
	
	public void run() { // 서버측으로부터 불시에 전달받게될 UDP
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
