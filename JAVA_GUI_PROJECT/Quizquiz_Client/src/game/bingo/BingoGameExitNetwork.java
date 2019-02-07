package game.bingo;

import java.util.Map;

import javax.swing.JPanel;

import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import data.user.User;
import pregame.waitingRoom.ClientWaitingRoomHandler;
import ui.game.bingo.BingoRoomUI;
import ui.game.bingo.BingoUserInfo;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class BingoGameExitNetwork extends Thread {
	ClientNetworkInfo clientNetwork;
	Map response;
	BingoRoomUI bingoGameRoomUI;
	BingoGameHandler bingoGameHandler;

	public BingoGameExitNetwork(ClientNetworkInfo clientNetwork, Map response, BingoRoomUI bingoGameRoomUI, BingoGameHandler bingoGameHandler) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.bingoGameRoomUI = bingoGameRoomUI;
		this.bingoGameHandler = bingoGameHandler;
	}
	
	@Override
	public void run() {
		User userQuitted = (User)response.get("user");
		
		if (clientNetwork.user.equals(userQuitted)) {
			bingoGameRoomUI.setVisible(false);
			bingoGameRoomUI.dispose();
			System.out.println("BingoRoom Stop");
			// 방장이었으면 아니라고 해준다
			clientNetwork.user.isOwner = false;
			// 웨이팅룸 들어가기
			WaitingRoomUI waitingRoomUI = new WaitingRoomUI(clientNetwork);
			waitingRoomUI.setVisible(true);
			clientNetwork.user.location = User.inWaitingRoom;
			ClientWaitingRoomHandler cWRHandler = new ClientWaitingRoomHandler(clientNetwork, waitingRoomUI);
			cWRHandler.start();
			
			
			bingoGameHandler.stop();			
		} else {
			bingoGameRoomUI.panelChat.taChatLog2.append(userQuitted.nickname + "님이 나가셨습니다.\n");
			BingoUserInfo bingoUserUI1 = bingoGameRoomUI.panelUser2;
			BingoUserInfo bingoUserUI2 = bingoGameRoomUI.panelUser3;
			
			System.out.println("bingoGameRoomUI.panelUser2 : null? " + (bingoGameRoomUI.panelUser2 == null));
			System.out.println("bingoGameRoomUI.panelUser3 : null? " + (bingoGameRoomUI.panelUser3 == null));
			
			if (bingoUserUI1 != null && bingoUserUI1.user.equals(userQuitted)) {
				bingoGameRoomUI.remove(bingoGameRoomUI.panelUser2);
				bingoGameRoomUI.revalidate();
				bingoGameRoomUI.repaint();
				bingoGameRoomUI.panelUser2 = null;
				System.out.println("bingoUserUI1 != null && bingoUserUI1.user.equals(userQuitted)");
			} 
			else if (bingoUserUI2 != null && bingoUserUI2.user.equals(userQuitted)) {
				bingoGameRoomUI.remove(bingoGameRoomUI.panelUser3);
				bingoGameRoomUI.revalidate();
				bingoGameRoomUI.repaint();
				bingoGameRoomUI.panelUser3 = null;
				System.out.println("bingoUserUI2 != null && bingoUserUI2.user.equals(userQuitted)");
			}
		}
		clientNetwork.user.gameRoom.joinedUsers.remove(userQuitted);
		ClientListManager.gameRoomsCreated.get(clientNetwork.user.gameRoom.roomNumber).joinedUsers.remove(userQuitted);
		
		
		
		
	}
	
	
}
