package manager.handler;

import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import pregame.login.LoginServer;
import pregame.waitingRoom.GameRoomRefreshServer;
import pregame.waitingRoom.RefreshConnectedUsersServer;

public class MainRequestHandler extends Thread {
public ServerNetworkStart serverNet;

public WaitingRoomHandler wrh;
public LoginServer loginServer;
	
	public MainRequestHandler(Socket socket) {
		serverNet = new ServerNetworkStart(socket);
	}
	
	private Map requestListener(Map request) {
		try {
			request = (Map) serverNet.ois.readObject();
			System.out.println("[MAIN REQUEST HANDLER] request received");
			return request;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (EOFException e) {
			e.printStackTrace();
			if (ListManager.usersInWaitingRoom.contains(this.wrh)) {
				ListManager.usersInWaitingRoom.remove(this.wrh);
			}
			if (loginServer != null && ListManager.usersLoggedIn.contains(loginServer)) {
				ListManager.usersLoggedIn.remove(loginServer);
				System.out.println("Remove LoginServer " + serverNet.user.id);
			}
			serverNet.close();
			
			for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
				WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
				RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(h.serverNet, null, h);
				rcus.refreshConnectedUsers();
			}			
			this.stop();
			return null;
		} catch (IOException e) {
			e.printStackTrace();

			if (ListManager.usersInWaitingRoom.contains(this.wrh)) {
				ListManager.usersInWaitingRoom.remove(this.wrh);
			}
			if (loginServer != null && ListManager.usersLoggedIn.contains(loginServer)) {
				ListManager.usersLoggedIn.remove(loginServer);
			}
			serverNet.close();
			this.stop();
			return null;
		}
	}
	
	
	@Override
	public void run() {
		Map request = null;
		// Login
		LoginRequestHandler lrh = null;
		// WaitingRoom
		wrh = null;
		// BingoGameRoom
		BingoGameRoomRequestHandler grh = null;
		while (serverNet.socket.isBound()) {
			if (serverNet.user == null) {
				// Request를 받기 전에 처리해야하는 것들 : 상황에 맞게 객체생성
				if (lrh == null) {
					lrh = new LoginRequestHandler(serverNet, this);
				}
				
				// 클라이언트로부터 Request
				if (serverNet.user != null) {
					System.out.println("[MAINREQUESTHANDLER] " +
							serverNet.user.id +
							" request listening");				
				}
				request = requestListener(request);
				// 로그인 & 회원가입 처리
				lrh.loginRequestHandler(request);		
			}
			
			// 유저가 대기방에 있을때
			else if (serverNet.user.location == User.inWaitingRoom) {
				if (wrh == null) {
					// 로그인이 되었을 시에 WaitingRoom에 입장
					// 혹은 게임방에서 나왔을 경우
					wrh = new WaitingRoomHandler(serverNet);				
				}
				
				// 게임방에 들어갔다가 나오면 게임방 핸들러 객체를 없엔다
				if (grh != null) {
					grh = null;
				}
				
				request = requestListener(request);
				wrh.waitingRoomRequestHandler(request);
			}
			
			// 유저가 게임방에 들어갔을때
			else if (serverNet.user.location == User.inGameRoom) {
				if (wrh != null) {
					wrh = null;
				}
				
				if (grh == null) {
					grh = new BingoGameRoomRequestHandler(serverNet);
				}
				
				request = requestListener(request);
				grh.bingoGameRoomRequestHandler(request);			
			}
			
		}
	}
	
	
}
