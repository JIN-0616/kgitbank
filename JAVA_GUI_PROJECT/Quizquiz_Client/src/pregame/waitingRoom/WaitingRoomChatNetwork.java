
package pregame.waitingRoom;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.network.ClientNetworkInfo;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class WaitingRoomChatNetwork extends Thread {

	ClientNetworkInfo net;
	WaitingRoomUI ui;
	Map response;
	//
	
	public WaitingRoomChatNetwork(ClientNetworkInfo clientNetwork, Map response, WaitingRoomUI ui) {
		net = clientNetwork;
		this.response = response;
		this.ui = ui;
	}

	public void sendChat(String message) {
		Map request = new Hashtable<>();
		request.put("mode", "chat");
		request.put("message", message);
		try {
			net.oos.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	// ==============================

	// 응답패킷이 수시로 들어올꺼라서 (요청을 보내야만 오는상황이 아님)
	public void run() {
			// 응답이 오면 이걸 가지고 여기서 UI 변경을 시켜야 함.
				chatHandle(response); // 모든 사용자에게 응답을 전송
				
	}

	//
	public void chatHandle(Map response) {
			String message = (String)response.get("message");
			String talker = (String)response.get("talker");
			System.out.println("message");
			String nval = "["+talker+"] " + message+"\n";
			ui.채팅방1.taChatLog.append(nval);
			ui.채팅방1.taChatLog.setCaretPosition(ui.채팅방1.taChatLog.getText().length());
		}

}
