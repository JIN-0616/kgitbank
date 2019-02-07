package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import data.gameRoom.GameRoom;
import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import ui.pregame.waitingRoom.GameRoomBtn;
import ui.pregame.waitingRoom.WaitingRoomUI;
import ui.pregame.waitingRoom.WrGameRoomDisplay;

public class WrGameRoomRefreshNetwork extends Thread {
	ClientNetworkInfo clientNetwork;
	Map response;
	WaitingRoomUI waitingRoomUI;
	
	// 리스너를 위한 생성자
	public WrGameRoomRefreshNetwork(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.response = response;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	@Override
	public void run() {
		boolean result = (boolean) response.get("result");
		if (result) {
			Map<Integer, GameRoom> cGRL = (Map) response.get("gameRoomList");
			System.out.println("cGRL null? : " + (cGRL == null));
			
			refresh(cGRL);
			System.out.println(clientNetwork.user.id + " refresh(cGRL) finished");
		} else {
			if (response.get("gameRoomList") != null) {
				if (waitingRoomUI.대기방목록 != null) {
					waitingRoomUI.remove(waitingRoomUI.대기방목록);
					waitingRoomUI.revalidate();
					waitingRoomUI.repaint();
				}
			}
		}
	}
	
	
	public void refresh(Map<Integer, GameRoom> cGRL) {
		System.out.println(clientNetwork.user.id + " refresh method");
		System.out.println(clientNetwork.user.id + " gameRoom size " + cGRL.size());
		if (waitingRoomUI.대기방목록 != null) {
			waitingRoomUI.remove(waitingRoomUI.대기방목록);			
		}
			waitingRoomUI.대기방목록 = new WrGameRoomDisplay(clientNetwork, waitingRoomUI);
			waitingRoomUI.대기방목록.setBounds(12, 53, 960, 360);
			waitingRoomUI.add(waitingRoomUI.대기방목록);
		// 클라이언트쪽 게임룸 리스트 갱신
		ClientListManager.gameRoomsCreated = cGRL;
		
		Set<Entry<Integer, GameRoom>> cGRLSet = cGRL.entrySet();
		for (Entry<Integer, GameRoom> e : cGRLSet) {
			if (cGRL.get(e.getKey()).joinedUsers.size() == 0) {
				cGRL.remove(e.getKey());
			}
		}
		
		for (Entry<Integer, GameRoom> e : cGRLSet) {
//			if (!ClientListManager.gameRoomsCreated.containsKey(cGRL.get(i).roomNumber)) {
//
//			}
			System.out.println("cGRL list: " + cGRL.get(e.getKey()).joinedUsers);
//			ClientListManager.gameRoomsCreated.put(cGRL.get(i).roomNumber, cGRL.get(i));
			System.out.println(cGRL.get(e.getKey()).roomNumber + " is Started? : " +
					ClientListManager.gameRoomsCreated.get(cGRL.get(e.getKey()).roomNumber).isStarted);
			
			
			GameRoomBtn grBtn = new GameRoomBtn();
			grBtn.gameRoom = cGRL.get(e.getKey());
			System.out.println("[grBtn gameRoom started? : " + grBtn.gameRoom.isStarted);
			grBtn.initFrame();
			
			waitingRoomUI.대기방목록.gameRooms.add(grBtn);
//			waitingRoomUI.대기방목록.add(waitingRoomUI.대기방목록.gameRooms.get(i));
			
			
//			System.out.println(e.getKey() + " gameRoomBtn is visible? : " + waitingRoomUI.대기방목록.gameRooms.get(e.getKey()).isVisible() );
			System.out.println(clientNetwork.user.id + " One Button added");
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		waitingRoomScreenImageRefresh();
		waitingRoomUI.대기방목록.addGameRooms();
		waitingRoomUI.대기방목록.actionListener();			
		waitingRoomUI.대기방목록.revalidate();
		waitingRoomUI.대기방목록.repaint();
	
	}
	
	
	
	private void waitingRoomScreenImageRefresh() {
		if (waitingRoomUI != null) {
			waitingRoomUI.remove(waitingRoomUI.screenDisplay);
			waitingRoomUI.screenDisplay = new JLabel("");
			waitingRoomUI.screenDisplay.setIcon(new ImageIcon("src\\image\\\uB300\uAE30\uBC29.jpg"));
			waitingRoomUI.screenDisplay.setBounds(0, 0, 984, 661);
			waitingRoomUI.getContentPane().add(waitingRoomUI.screenDisplay);			
		}
	}
	
	
	
//	public void refresh(List<GameRoom> cGRL) {
//		System.out.println(clientNetwork.user.id + " refresh method");
//		System.out.println(clientNetwork.user.id + " gameRoom size " + cGRL.size());
//		int btnIndex = 0;
//		int cGRLIndex = 0;
//		while (cGRLIndex < cGRL.size() && btnIndex < cGRL.size()) {
//			if (!ClientListManager.gameRoomsCreated.contains(cGRL.get(cGRLIndex))) {
//				System.out.println(clientNetwork.user.id + " One Button adding started");
//				WrGameRoomDisplay wGRD = (WrGameRoomDisplay) waitingRoomUI.대기방목록;

//				if (!wGRD.gameRooms.get(btnIndex).isVisible()) {
//					GameRoomBtn grbtn = new GameRoomBtn();
//					grbtn.setGameRoom(cGRL.get(cGRLIndex));
//					wGRD.gameRooms.set(btnIndex, grbtn);
//					wGRD.gameRooms.get(btnIndex).setVisible(true);
//					System.out.println(cGRL.get(cGRLIndex).joinedUsers.size());
//					System.out.println(wGRD.gameRooms.get(btnIndex).gameRoom.joinedUsers.size());
//					System.out.println(btnIndex + " gameRoomBtn is visible? : " + wGRD.gameRooms.get(btnIndex).isVisible() );
//					System.out.println(clientNetwork.user.id + " One Button added");	
//					ClientListManager.gameRoomsCreated.add(cGRL.get(cGRLIndex));
					
//					wGRD.gameRooms.get(btnIndex).repaint();
					
//					btnIndex++;
//					cGRLIndex++;
//				} 
//				else {
//					btnIndex++;
//				}
				
//			}
//			waitingRoomUI.대기방목록.revalidate();
//			waitingRoomUI.대기방목록.repaint();
//		}
//	}
	
	
	
	
//	동적으로 작동 : 안됨
	
//	public void refresh(List<GameRoom> cGRL) {
//		System.out.println(clientNetwork.user.id + " refresh method");
//		System.out.println(clientNetwork.user.id + " gameRoom size " + cGRL.size());
//		for (int i=0; i<cGRL.size(); i++) {
//			if (!ClientListManager.gameRoomsCreated.contains(cGRL.get(i))) {
//				System.out.println(clientNetwork.user.id + " One Button adding started");
//				GameRoomBtn gb = new GameRoomBtn(cGRL.get(i));
//				ClientListManager.gameRoomsCreated.add(cGRL.get(i));
//				
//				waitingRoomUI.대기방목록.add(gb);
//				
//				System.out.println(clientNetwork.user.id + " One Button added");				
//			}
//		}
//		waitingRoomUI.대기방목록.repaint();
//	}
	

	
	
	// send 를 위한 생성자
	public WrGameRoomRefreshNetwork(ClientNetworkInfo clientNetwork) {
		this.clientNetwork = clientNetwork;
	}
	
	 //REFRESH 버튼을 만약 생성했을때 사용할 것

	public boolean sendRefreshGameroomList () {
		Map<String, Object> request = new Hashtable<String, Object>();
		request.put("mode", "refreshGameroomList");
		try {
			clientNetwork.oos.writeObject(request);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
}
