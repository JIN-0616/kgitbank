package pregame.waitingRoom;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.JList;

import data.gameRoom.GameRoom;
import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import ui.pregame.waitingRoom.GameRoomBtn;
import ui.pregame.waitingRoom.WaitingRoomUI;
import ui.pregame.waitingRoom.WrGameRoomDisplay;

public class UsersRefreshNetwork extends Thread {
	ClientNetworkInfo clientNetwork;
	Map response;
	WaitingRoomUI waitingRoomUI;
	
	// 리스너를 위한 생성자
	public UsersRefreshNetwork(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	@Override
	public void run() {
		boolean result = (boolean) response.get("result");
		if (result) {
			List<String> usersConnectedList = (List) response.get("usersList");
			System.out.println("usersConnectedLis null? : " + (usersConnectedList == null));
			
			refreshUsers(usersConnectedList);
			System.out.println(clientNetwork.user.id + " refresh users finished");
		} else {
			if (response.get("usersListt") != null) {
				if (waitingRoomUI.panelWU.model != null) {
					waitingRoomUI.panelWU.model.removeAllElements();
					waitingRoomUI.panelWU.revalidate();
					waitingRoomUI.panelWU.repaint();
				}
			}
		}
	}
	
	
	public void refreshUsers(List<String> usersConnectedList) {
		System.out.println(clientNetwork.user.id + " refresh user method");
		System.out.println(clientNetwork.user.id + " user connected list size " + usersConnectedList.size());
		
		waitingRoomUI.panelWU.model.removeAllElements();
		
		for (String nickname : usersConnectedList) {
			
			waitingRoomUI.panelWU.model.addElement((String)nickname);				
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitingRoomUI.panelWU.revalidate();
		waitingRoomUI.panelWU.repaint();
	
	}
	
}
