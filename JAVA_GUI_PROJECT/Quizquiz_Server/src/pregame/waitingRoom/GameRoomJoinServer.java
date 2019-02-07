package pregame.waitingRoom;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import manager.handler.BingoGameRoomRequestHandler;
import manager.handler.WaitingRoomHandler;

/**
 * @author Hee Sang Shin
 * @version 1.0
 * @date 2018.05.29
 * 
 * 대기방에서 게임방 접속시 요청을 처리해주는 서버
 *
 */

public class GameRoomJoinServer {
	ServerNetworkStart serverNet;
	Map request;
	WaitingRoomHandler handler;
		
	// 조인 성공 및 실패
	public static int SUCCESS = 2011;
	public static int FAILED = 2012;
	
	// 생성자
	public GameRoomJoinServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) {
		this.serverNet = serverNet;	
		this.request = request;	
		this.handler = handler;
	}
	

//		if () {
//			WaitingRoomServer.usersInWaitingRoom.remove(user);			
//		}

		// 로그인 메소드
		/* 
		 * 로그인 시 : 
		 */
	public void joinGameRoom(Map request) {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "joinGameRoom");
		int result = 0;
		
		GameRoom gameRoom = (GameRoom)request.get("gameRoom");
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom null? : " + (gameRoom == null));
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom room number : " + gameRoom.roomNumber);
		System.out.println("[GAMEROOM JOIN SERVER] gameRoom started? : " + gameRoom.isStarted);
		
		Map<Integer, GameRoom> cGRL = ListManager.gameRoomsCreated;

		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 만약 게임방이 생성이 되어있고 꽉 차있지 않으면
		// 성공
		if (cGRL.containsValue(gameRoom) && gameRoom.isFull == false && gameRoom.isStarted == false) {
			GameRoom gameRoomToManage = ListManager.gameRoomChannels.get(gameRoom).get(0).gameRoom;
			// 게임방에 유저 정보를 입력 서버측 && 유저에게 보낼거
			for (int i=0; i<3; i++) {
				System.out.println("[GAMEROOM JOIN SERVER] join iteration: " + i + "th.\n "
						+ "user yes? : " + (gameRoomToManage.joinedUsers.containsValue(i)));

				if (gameRoomToManage.joinedUsers.containsValue(i) == false) {
					System.out.println("[GAMEROOM JOIN SERVER] adding user started " + serverNet.user.id);
					// 게임 채널 관리 맵에 저장
					gameRoomToManage.joinedUsers.put(serverNet.user, i);
					System.out.println("[GAMEROOM JOIN SERVER] gameRoomToManage user added " + serverNet.user.id);
					System.out.println("[GAMEROOM JOIN SERVER] gameRoomToManage : " + gameRoomToManage.joinedUsers);
//					// 생성된 게임 리스트 맵에 저장
//					cGRL.get(gameRoom.roomNumber).joinedUsers.put(serverNet.user, i);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
//					// 유저에게 보낼 게임방 정보에 저장
//					gameRoom.joinedUsers.put(serverNet.user, i);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
//					System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
					
					break;
				}
				
			}
			//for
			
			// 생성된 게임 리스트 맵에 저장
			cGRL.get(gameRoom.roomNumber).joinedUsers = gameRoomToManage.joinedUsers;
			System.out.println("[GAMEROOM JOIN SERVER] cGRL user added " + serverNet.user.id);
			System.out.println("[GAMEROOM JOIN SERVER] cGRL : " + cGRL.get(gameRoom.roomNumber).joinedUsers);
			// 유저에게 보낼 게임방 정보에 저장
			gameRoom.joinedUsers = gameRoomToManage.joinedUsers;
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom user added " + serverNet.user.id);
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom :  " + gameRoom.joinedUsers);
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("[GAMEROOM JOIN SERVER] gameRoom joined users list : " + gameRoom.joinedUsers);
			
			// 게임방에 유저 추가후, 게임방 상태 저장
			if (gameRoom.joinedUsers.size() == gameRoom.maxPlayers) {
				System.out.println("[GAMEROOM JOIN SERVER] setFull started");
				gameRoomToManage.isFull = true;
				cGRL.get(gameRoom.roomNumber).isFull = true;
				gameRoom.isFull = true;
			}
			// 대기방 리스트에서 유저정보 삭제
			ListManager.usersInWaitingRoom.remove(handler);
			serverNet.user.location = User.inGameRoom;
			serverNet.user.gameRoom = gameRoom;
			result = SUCCESS;
			response.put("result", result);
			System.out.println("[GAMERoom-SERVER] ok join gameRoom Number " + gameRoom.roomNumber);
		}
		// 아닐경우
		else {
			result = FAILED;
			response.put("result", result);
		}
		
		// 게임방 및 게임룸 리스트를 보내준다
		response.put("gameRoom", gameRoom);
		response.put("gameRoomList", cGRL);
			
		try {
			serverNet.oos.writeObject(response);
			System.out.println("[GAMERoomJOIN-SERVER] response sent" + response.get("result"));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == SUCCESS) {
			// 유저를 대기방에서 나가게 함
			ListManager.usersInWaitingRoom.remove(handler);
			
			// 해당 게임방에 있는 사람들에게 들어 갔다는것을 알려줌
			System.out.println("[GAMERoomJOIN-SERVER] game joined notice");
			List<BingoGameRoomRequestHandler> listUsersInGameRoom = ListManager.gameRoomChannels.get(gameRoom);
			response = new Hashtable<String, Object>();
			response.put("mode", "gameRoomUsersModified");
			response.put("gameRoom", gameRoom);
			response.put("newUser", serverNet.user);
			System.out.println("[GAMERoomJOIN-SERVER] gameRoom joinedUsers : " + gameRoom.joinedUsers);
			for (BingoGameRoomRequestHandler h : listUsersInGameRoom) {
				if (h.serverNet.equals(this.serverNet) == false) {
					try {
						h.serverNet.oos.reset();
						h.serverNet.oos.writeObject(response);
						System.out.println("[GAMERoomJOIN-SERVER] new user joined data sent to " + h.serverNet.user.id);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			// for
		}
		// if
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 대기방에 있는 사람들에게 방 리스트 새로고침
		System.out.println("[GAMERoomJOIN-SERVER] refresh action");
		System.out.println("[GAMERoomJOIN-SERVER] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
		for (int i=0; i<ListManager.usersInWaitingRoom.size(); i++) {
			System.out.println(ListManager.usersInWaitingRoom.get(i).serverNet.user.id);
			WaitingRoomHandler h = ListManager.usersInWaitingRoom.get(i);
			GameRoomRefreshServer grs = new GameRoomRefreshServer(h.serverNet, null, h);
			grs.gameRoomListRefresh();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RefreshConnectedUsersServer rcus = new RefreshConnectedUsersServer(h.serverNet, null, h);
			rcus.refreshConnectedUsers();
		}
		
	}
	
	
	
}
