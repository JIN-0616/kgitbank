package data.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import data.user.User;

public class ServerNetworkStart {
	public User user;
	
	public String ip;
	public int port;
	public Socket socket;
	
	public ObjectOutputStream oos;
	public ObjectInputStream ois;
	
	
	//============================================

	
	public ServerNetworkStart(Socket socket){
		try {
			this.socket = socket;
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			System.out.println("[SERVER] " + socket.getInetAddress() +
					" disconnected");
			socket = null;
			ois = null;
			oos = null;
			e.printStackTrace();
			return;
		}
	}
	
	public boolean close() {
		try  {
			if (this.oos != null) oos.close();
			if (this.ois != null) ois.close();
			if (this.socket != null) socket.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	@Override
	public boolean equals(Object obj) {
		ServerNetworkStart otherNetInfo = (ServerNetworkStart) obj;
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
