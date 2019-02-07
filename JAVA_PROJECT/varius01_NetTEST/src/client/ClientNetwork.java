package client;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Map;

import javax.swing.JOptionPane;

public class ClientNetwork extends Thread {
	ClientUI ui;

	Socket socket; // �� �ٽɿ��� ����
	ObjectOutputStream oos;
	ObjectInputStream ois;

	DatagramSocket dataSocket; // ������� (���ú��)

	public ClientNetwork(String ip, ClientUI ui) {
		this.ui = ui;
		try {
			socket = new Socket(ip, 56789);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			dataSocket = new DatagramSocket(socket.getLocalPort());
			start();
			sendStatusRequest();
		} catch (IOException e) {
			System.out.println("[client] network error");
			JOptionPane.showMessageDialog(ui, "��Ʈ��ũ����\n������ �����̴�.");
			throw new RuntimeException();
		}
	}

	public void sendMoveRequest(String mode) {
		try {
			synchronized (oos) {
				String req = "move#" + mode;
				oos.writeObject(req);
				boolean r =(boolean)ois.readObject();
				if(r) {
					JOptionPane.showMessageDialog(ui, "congratulation!");
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}

	public void sendStatusRequest() {
		try {
			synchronized (oos) {
				String req = "status";
				oos.writeObject(req);
				Map data =(Map)ois.readObject();
				boolean[][] map = (boolean[][])data.get("map");
				int currCol = (int)data.get("currCol");
				int currRow = (int)data.get("currRow");
				for(int r=0; r<30; r++) {
					for(int c=0; c<30; c++) {
						if(map[r][c]) {
							if(r==currRow && c ==currCol) {
								ui.lbs[r][c].setBackground(Color.BLACK);
							}else {
								ui.lbs[r][c].setBackground(Color.WHITE);
							}
						}else {
							ui.lbs[r][c].setBackground(Color.LIGHT_GRAY);
						}
					}
				}
			}
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.toString());
		}

	}

	// ���������κ��� �ҽÿ� ���޹ްԵ� �˸���Ŷ�� ó���ϴ� �κ�
	public void run() {
		while (!dataSocket.isClosed()) {
			try {
				DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
				dataSocket.receive(p);
				String alram = new String(p.getData(), 0, p.getLength());
				System.out.println("[client] packet received : " + alram);
				switch (alram) {
				case "moved":
					sendStatusRequest();
					break;
				case "found":
					JOptionPane.showMessageDialog(ui, "tresure was found by user, and then moved");
				}
			} catch (IOException e) {
				dataSocket.close();
				break;
			}
		}
	}

}
