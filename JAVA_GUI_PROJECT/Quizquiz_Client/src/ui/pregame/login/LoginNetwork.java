package ui.pregame.login;

import java.io.IOException;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;

import data.network.ClientNetworkInfo;
import data.user.User;

public class LoginNetwork {

	ClientNetworkInfo clientNetwork;
	
	//============================================
	public LoginNetwork(ClientNetworkInfo clientNetwork) {							//생성자
		this.clientNetwork = clientNetwork;
	}
	
	
	
	public Map sendJoin(String id, String pass,String nick) {							//회원가입 전송 메소드
		Map request = new Hashtable<>();
		User user=new User(id,pass,nick);
		request.put("user", user);
		request.put("mode", "join");
		request.put("nick", nick);
		try {
			clientNetwork.oos.writeObject(request);
			return (Map)clientNetwork.ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
			
		} 
	}
	
	public Map sendLogin(String id, String pass) {										//로그인 전송 메소드
		Map request = new Hashtable<>();
		User user=new User(id,pass);
		request.put("user", user);
		request.put("mode", "login");
		try {
			clientNetwork.oos.writeObject(request);
			return (Map)clientNetwork.ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			return null;
		} 
	}
	
}
