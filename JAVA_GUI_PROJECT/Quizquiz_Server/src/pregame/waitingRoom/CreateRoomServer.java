package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.gameRoom.GameRoom;
import data.manager.ListManager;
import data.network.ServerNetworkStart;
import data.user.User;
import game.CardGameServer;
import manager.handler.WaitingRoomHandler;

public class CreateRoomServer {
	ServerNetworkStart serverNet;
	WaitingRoomHandler handler;
	
	
	public static int SUCCESS = 1031;									//방 생성 성공코드 1031
	public static int FAILED = 1032;									//방 생성 실패코드 1032
	ListManager createdGameRoom;
	GameRoom gameRoom;
	
	// 네트워크 연결
	public Map<String, Object> request;

	public CreateRoomServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) { 	// 생성자
		this.serverNet = serverNet;
		this.request = request;
		this.handler = handler;
	}

	public void createRoom(Map<String, Object> request) {				//createRoom 메소드	
		Map<String, Object> response = new Hashtable<String, Object>();
		String game = (String) request.get("game");
			switch (game) {												//game 모드에 따라 작동
			case "bingo": {												//bingo 모드
				if (ListManager.gameRoomsCreated.size() == 6) {			//방 갯수가 6개일 경우 더이상 만들수 없으므로 만들지 않고 결과값 전송
					response.put("mode", "createGameRoom");
					response.put("game", game);
					response.put("bingo", gameRoom);
					response.put("result", FAILED);
				} else {					
				//방을 만들 수 있는 경우 방 생성
				gameRoom = new GameRoom(3);
				// 방제목 설정
				String title = (String) request.get("title");
				gameRoom.title = title;
				// 방에 있는 유저 정보에 자신을 추가
				gameRoom.joinedUsers.put(serverNet.user, 0);
				ListManager.gameRoomsCreated.put(gameRoom.roomNumber, gameRoom);
				System.out.println("[CREATEROOM-SERVER] bingoRoom:" + gameRoom + " " + gameRoom.roomNumber);
				System.out.println("[CREATEROOM-SERVER] bingoRoom joineduser null?:" + (gameRoom.joinedUsers == null));
				serverNet.user.isOwner = true;
				// 유저가 게임방에 들어갔다고 알려준다
				serverNet.user.gameRoom = gameRoom;
				serverNet.user.location = User.inGameRoom;								
				
				
				
				
				response.put("mode", "createGameRoom");
				response.put("game", game);
				response.put("bingo", gameRoom);
				response.put("result", SUCCESS);

				}
			}
			break;
			case "card": {												//card 모드
				if (createdGameRoom.gameRoomsCreated.size() == 6) {			//방 갯수 6개인지 확인
					response.put("mode", "createGameRoom");
					response.put("game", "card");
					response.put("bingo", gameRoom);
					response.put("result", FAILED);
				} else {													//방을 만들 수 있는 경우 방 생성
					gameRoom = new GameRoom(3);
					gameRoom.joinedUsers.put(serverNet.user, 0);
					ListManager.gameRoomsCreated.put(gameRoom.roomNumber, gameRoom);
					serverNet.user.isOwner = true;
					serverNet.user.location = User.inGameRoom;
					serverNet.user.gameRoom = gameRoom;
				
					// 카드게임 서버 스타트
					CardGameServer cg = new CardGameServer();
					cg.start();					
					response.put("mode", "createGameRoom");
					response.put("game", "card");
					response.put("bingo", gameRoom);
					response.put("result", SUCCESS);
//					response.put("result", FAILED);
				}
			}
			break;
		}
		//switch
		try {
			//결과값 전송
			serverNet.oos.writeObject(response);
			System.out.println("[CreateRoomServer] response sent to " + serverNet.user.id);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 대기방에 있는 사람들에게 방 리스트 새로고침
		System.out.println("[CREATEROOMSEVER] refresh action");
		ListManager.usersInWaitingRoom.remove(handler);
		System.out.println("[CREATEROOMSERVER] usersInWaitingRoom size : " + ListManager.usersInWaitingRoom.size());
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
