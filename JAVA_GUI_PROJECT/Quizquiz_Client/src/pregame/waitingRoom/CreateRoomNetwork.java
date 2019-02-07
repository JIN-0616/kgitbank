package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JOptionPane;

import data.gameRoom.GameRoom;
import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import data.user.User;
import game.bingo.BingoGameHandler;
import ui.game.bingo.BingoRoomUI;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class CreateRoomNetwork {

	ClientNetworkInfo clientNetwork;
	Map response;
	WaitingRoomUI waitingRoomUI;

	public static int SUCCESS = 1031;									//방 생성 성공코드 1031
	public static int FAILED = 1032;
	
	
	public CreateRoomNetwork(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	public void createRoom(Map response) {
		int result = (int) response.get("result");
		if (result == SUCCESS) {
			JOptionPane.showMessageDialog(waitingRoomUI, "게임방 생성 성공");
			String game = (String) response.get("game");
			
			System.out.println("game? : " + game);
			if (game.equals("bingo")) {
				clientNetwork.user.isOwner = true;
				GameRoom bingoRoom = (GameRoom) response.get("bingo");
				clientNetwork.user.gameRoom = bingoRoom;
				ClientListManager.gameRoomsCreated.put(bingoRoom.roomNumber, bingoRoom);
				
				BingoRoomUI bingoRoomUI = new BingoRoomUI(clientNetwork, bingoRoom);
				bingoRoomUI.setVisible(true);
				System.out.println("bingoroomUI on");
				// User가 게임방에 들어갔다고 알려준다
				clientNetwork.user.location = User.inGameRoom;
				
	            BingoGameHandler bgh = new BingoGameHandler(clientNetwork,bingoRoomUI);
	            bgh.start();
			}

			waitingRoomUI.dispose();
			waitingRoomUI.setVisible(false);		
			
			// 게임방에 들언간다
//			else if (game.equals("card")) {
//				GameRoom bingoRoom = (GameRoom) response.get("bingo");
//				BingoRoomUI bingoRoomUI = new BingoRoomUI(clientNetwork, bingoRoom);
//				bingoRoomUI.setVisible(true);
//			}
			
		} else if (result == FAILED) {
			JOptionPane.showMessageDialog(waitingRoomUI, "게임방 생설 실패");
		}
	}
	
	public CreateRoomNetwork(ClientNetworkInfo clientNetwork) {					//생성자
		this.clientNetwork = clientNetwork;
	}
	
	
	public boolean sendCreate(String game, String title) {								//게임생성 신호 메소드
		Map<String, Object> request = new Hashtable<>();
		request.put("mode", "createRoom");
		request.put("game", game);
		request.put("title", title);
		
		try {
			//신호 전송
			clientNetwork.oos.writeObject(request);
			System.out.println("[CreateRoomNet] SENT request " + clientNetwork.user.id + " game? :" + game);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
			
		}
	}




}