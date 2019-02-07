package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.WaitingRoomHandler;

public class RefreshConnectedUsersServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	WaitingRoomHandler waitingRoomHandler;

	public RefreshConnectedUsersServer(ServerNetworkStart serverNet, Map request,
			WaitingRoomHandler waitingRoomHandler) {
		this.serverNet = serverNet;	
		this.request = request;
		this.waitingRoomHandler = waitingRoomHandler;
		
	}
	
	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			refreshConnectedUsers();
		}
	}
	
	public void refreshConnectedUsers() {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "refreshConnectedUsers");
		
		
		
//		System.out.println("[Users REFRESH SERVER] usersConnectedList null? : " + (usersConnectedList == null));
//		System.out.println("[Users REFRESH SERVER] usersConnectedList size : " + usersConnectedList.size());
		
		List<String> usersConnectedList = new Vector<String>();
		for (WaitingRoomHandler h : ListManager.usersInWaitingRoom) {
			usersConnectedList.add(h.serverNet.user.nickname);
		}
		
		response.put("usersList", usersConnectedList);
		if (ListManager.usersInWaitingRoom == null || ListManager.usersInWaitingRoom.isEmpty()) {
			response.put("result", false);
		} else {
			response.put("result", true);
		}
			
		try {
			serverNet.oos.reset();
			serverNet.oos.writeObject(response);
			System.out.println("[GAMERoomREFRESH-SERVER] response sent " + serverNet.user.id + response.get("result"));
//			System.out.println("[GAMERoomREFRESH-SERVER] cGRL size " + cGRL.size());
//			System.out.println("[GAMERoomREFRESH-SERVER] cGRL sent size " + ((Map)response.get("gameRoomList")).size());
//			System.out.println("[GAMERoomREFRESH-SERVER] cGRL :  " + ((Map)response.get("gameRoomList")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
			
		}
	}

}
