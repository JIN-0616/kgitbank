package pregame.waitingRoom;

import java.util.Map;

import data.network.ClientNetworkInfo;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class ClientWaitingRoomHandlerThread extends Thread {
	ClientNetworkInfo clientNetwork;
	Map response;
	WaitingRoomUI waitingRoomUI;
	
	
	public ClientWaitingRoomHandlerThread(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	@Override
	public void run() {
		String mode = (String)response.get("mode");
		switch(mode) {
		case "chat":{
			WaitingRoomChatNetwork wCN = new WaitingRoomChatNetwork(clientNetwork, response , waitingRoomUI);
			System.out.println("채팅 모드 돌입");

			wCN.start();
			break;
		}
		case "refreshGameRoomList":
			WrGameRoomRefreshNetwork grn = new WrGameRoomRefreshNetwork(clientNetwork, response, waitingRoomUI);
			grn.start();
			break;
		case "refreshConnectedUsers":
			UsersRefreshNetwork urn = new UsersRefreshNetwork(clientNetwork, response, waitingRoomUI);
			urn.start();
			break;
		}
	}
	
}
