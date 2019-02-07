package manager.handler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import pregame.login.LoginServer;
import pregame.login.SignUpServer;

/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * 첫화면에서 로그인 및 회원가입 요청을 듣는 헨들러(서버)
 *
 */

public class LoginRequestHandler {
	ServerNetworkStart serverNet;
	MainRequestHandler mainRequestHandler;
	
	public LoginRequestHandler(ServerNetworkStart serverNet, MainRequestHandler mainRequestHandler) {
		this.serverNet = serverNet;
		this.mainRequestHandler = mainRequestHandler;
	}
	
	private Map requestListener(Map request) {
		try {
			request = (Map) serverNet.ois.readObject();
			System.out.println("[LOGIN REQUEST HANDLER] request received");
			return request;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return request;
		}
	}
	
	public void loginRequestHandler(Map request) {
		String mode = (String) request.get("mode");
		System.out.println("[LOGIN REQUEST HANDLER] request mode : " + mode);				
		switch(mode) {
		case "login":
			LoginServer ls = new LoginServer(serverNet, request, mainRequestHandler);
			ls.login(request);
			break;
		case "join":
			SignUpServer ss;
			ss = new SignUpServer(serverNet, request);
			ss.signUp(request);
			break;
		}	
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof LoginRequestHandler)) {
			return false;
		}
		
		LoginRequestHandler otherH = (LoginRequestHandler) obj;
		if (this.serverNet.user.equals(otherH.serverNet.user)) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		if (serverNet == null) {
			return -1;
		}
		return serverNet.user.hashCode();
	}
	
}
