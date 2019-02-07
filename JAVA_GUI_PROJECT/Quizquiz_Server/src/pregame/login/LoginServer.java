package pregame.login;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import data.manager.ExistingUser;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import manager.handler.MainRequestHandler;

/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * �α����� ó�����ִ� ����
 *
 */

public class LoginServer {
	ServerNetworkStart serverNet;
	
	MainRequestHandler mainRequestHandler;
	
	// �α��� ���� �� ����
	public static int SUCCESS = 1001;
	public static int FAILED = 1002;
	public static int NOT_VALID_PASSWORD = 1003;
	public static int ALREADY_IN = 1004;
	
	// Request
	public Map<String, Object> request;
	
	// ������ - �⺻ ����
	public LoginServer(ServerNetworkStart serverNet, Map request, MainRequestHandler mainRequestHandler) {
			this.request = request;
			this.serverNet = serverNet;
			this.mainRequestHandler = mainRequestHandler;
			
			System.out.println("[LOGIN-SERVER] connected");
	}
	

	// �α��� �޼ҵ�
	/* 
	 * �α��� �� : 
	 * 	1. "login" �޽����� Ŭ���̾�Ʈ���� �����ش�
	 *  2. �α��� ������ int SUCCESS �� �����ش�
	 *     �α��� ���н� int FAILED �� �����ش�
	 *  3. �α����� ������ �и��Ѵ� (Userconnected.connectedUsers pool�� ����)
	 */
	public void login(Map request) {
		// �α����� ������ �޴´� : user
		User user = (User) request.get("user");
		System.out.println("[LOGIN-SERVER] login wanted user got");
		Map<String, Object> response = new Hashtable<String, Object>();
		
		response.put("mode", "login");
		
		// save ���Ͽ��� �� user������ �ִ��� Ȯ���Ѵ�
		if (ExistingUser.existingUsers.contains(user)) {
			// save ���Ͽ��� �ش� user������ �����´�
			List<User> listU = new Vector<User>();
			listU.addAll(ExistingUser.existingUsers);
			User checkUser = new User();
			for (User u : listU) {
				if (u.id.equals(user.id)) {
					checkUser = u;
					System.out.println("[LoginServer] user checked");
					break;
				}
			}
			
			// if
			if (checkUser.password.equals(user.password)) {
				serverNet.user = checkUser;
				System.out.println(ListManager.usersLoggedIn.contains(this));
				if (ListManager.usersLoggedIn.contains(this)) {
					response.put("result", ALREADY_IN);
					serverNet.user = null;
				} else {
					response.put("user", checkUser);
					serverNet.user.location = User.inWaitingRoom;				
					// result�� �����̶�� �����ش�
					response.put("result", SUCCESS);
					System.out.println("[LOGIN-SERVER] ok");
					// �α��� �� ���� ����Ʈ�� ����
					ListManager.usersLoggedIn.add(this);
					mainRequestHandler.loginServer = this;
				}
			} else {
				response.put("result", NOT_VALID_PASSWORD);
				System.out.println("[LOGIN-SERVER] not valid password");
			}
			//  if			
		} else {
			response.put("result", FAILED);
		}
		
		try {
			serverNet.oos.writeObject(response);
			System.out.println("[LOGIN-SERVER] response sent" + response.get("result"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LoginServer) {
			LoginServer otherLS = (LoginServer) obj;
			if (this.serverNet.equals(otherLS.serverNet)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		if (this.serverNet != null) {
			return this.serverNet.user.hashCode();
		} else {
			return -1;
		}
	}
	
	
}
