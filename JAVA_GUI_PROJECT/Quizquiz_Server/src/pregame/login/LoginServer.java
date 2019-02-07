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
 * 로그인을 처리해주는 서버
 *
 */

public class LoginServer {
	ServerNetworkStart serverNet;
	
	MainRequestHandler mainRequestHandler;
	
	// 로그인 성공 및 실패
	public static int SUCCESS = 1001;
	public static int FAILED = 1002;
	public static int NOT_VALID_PASSWORD = 1003;
	public static int ALREADY_IN = 1004;
	
	// Request
	public Map<String, Object> request;
	
	// 생성자 - 기본 세팅
	public LoginServer(ServerNetworkStart serverNet, Map request, MainRequestHandler mainRequestHandler) {
			this.request = request;
			this.serverNet = serverNet;
			this.mainRequestHandler = mainRequestHandler;
			
			System.out.println("[LOGIN-SERVER] connected");
	}
	

	// 로그인 메소드
	/* 
	 * 로그인 시 : 
	 * 	1. "login" 메시지를 클라이언트에게 보내준다
	 *  2. 로그인 성공시 int SUCCESS 를 보내준다
	 *     로그인 실패시 int FAILED 를 보내준다
	 *  3. 로그인한 유저로 분리한다 (Userconnected.connectedUsers pool에 저장)
	 */
	public void login(Map request) {
		// 로그인한 유저를 받는다 : user
		User user = (User) request.get("user");
		System.out.println("[LOGIN-SERVER] login wanted user got");
		Map<String, Object> response = new Hashtable<String, Object>();
		
		response.put("mode", "login");
		
		// save 파일에서 이 user정보가 있는지 확인한다
		if (ExistingUser.existingUsers.contains(user)) {
			// save 파일에서 해당 user정보를 꺼내온다
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
					// result를 성공이라고 보내준다
					response.put("result", SUCCESS);
					System.out.println("[LOGIN-SERVER] ok");
					// 로그인 한 유저 리스트에 저장
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
