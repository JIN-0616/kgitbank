package data.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import data.user.User;

public class ClientNetworkInfo {
	public User user;
	public String ip;
	public int port;
	public Socket socket;
	
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	
	//============================================
	
	
	public ClientNetworkInfo(String ip, int port){
		this.ip = ip;
		this.port = port;
		try {
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			JOptionPane.showMessageDialog(null, "접속이 되었습니다");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "접속이 불가능합니다.");
			socket = null;
			oos = null;
			ois = null;
		}
	}
	
	public void close() {
		try {
			if (ois != null) ois.close();
			if (oos != null) oos.close();
			if (socket != null) socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		ClientNetworkInfo otherNetInfo = (ClientNetworkInfo) obj;
		if (user.equals(otherNetInfo.user)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return user.hashCode();
	}
}
