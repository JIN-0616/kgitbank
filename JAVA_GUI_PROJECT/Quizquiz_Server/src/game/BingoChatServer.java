package game;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.manager.ListManager;
import data.network.ServerNetworkStart;
import manager.handler.BingoGameRoomRequestHandler;

public class BingoChatServer extends Thread {
	ServerNetworkStart serverNet;
	Map request;
	BingoGameRoomRequestHandler bingoGameRoomRequestHandler;
	
	public BingoChatServer(ServerNetworkStart serverNet, Map request,
			BingoGameRoomRequestHandler bingoGameRoomRequestHandler) {
		
		this.serverNet = serverNet;
		this.request = request;
		this.bingoGameRoomRequestHandler = bingoGameRoomRequestHandler;
	}
	
	
	@Override
	public void run() {
			bingoChat(request);
	}
		
	public void bingoChat(Map<String, Object> request)  {
		Map<String, Object> response = new Hashtable<String, Object>();
		response.put("mode", "bingoChat");
		
		String[] ban = "¹Ùº¸,¸ÛÃ»ÀÌ,¿å".split(",");
		String message = (String) request.get("message");
		for (String m : ban) {
			message = message.replace(m, "****");
		}
		response.put("message", message);
		
		for (BingoGameRoomRequestHandler h : ListManager.gameRoomChannels.get(serverNet.user.gameRoom)) {
			try {
				response.put("talker", serverNet.user.nickname);
				h.serverNet.oos.writeObject(response);
				System.out.println(h.serverNet.user.nickname + "Àü¼Û");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
