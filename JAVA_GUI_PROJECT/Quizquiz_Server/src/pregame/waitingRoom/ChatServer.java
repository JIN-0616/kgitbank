package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.WaitingRoomHandler;

public class ChatServer extends Thread {
	ServerNetworkStart serverNet;
	WaitingRoomHandler handler;
	ListManager WaitingRoomHandle;
	public Map<String, Object> request; 


	public ChatServer(ServerNetworkStart serverNet, Map request, WaitingRoomHandler handler) {
		this.serverNet = serverNet;
		this.request = request;
		this.handler = handler;
	}

	
	// 쓰레드
	@Override
	public void run() {
		if (serverNet.socket.isBound()) {
			chat(request);			
		}
	}
		
	public void chat(Map<String, Object> request)  {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "chat");
		
		String[] ban = "바보,멍청이,욕".split(",");
		String message = (String) request.get("message");
		for (String m : ban) {
			message = message.replace(m, "****");
		}
		response.put("message", message);
		for (WaitingRoomHandler h : ListManager.usersInWaitingRoom) {
			try {
				response.put("talker", serverNet.user.nickname);
				h.serverNet.oos.reset();
				h.serverNet.oos.writeObject(response);
				System.out.println(h.serverNet.user.nickname + "전송");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}