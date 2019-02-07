
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

	// ������Ŷ�� ���÷� ���ò��� (��û�� �����߸� ���»�Ȳ�� �ƴ�)
	public void run() {
			// ������ ���� �̰� ������ ���⼭ UI ������ ���Ѿ� ��.
				chatHandle(response); // ��� ����ڿ��� ������ ����
				
	}

	//
	public void chatHandle(Map response) {
			String message = (String)response.get("message");
			String talker = (String)response.get("talker");
			System.out.println("message");
			String nval = "["+talker+"] " + message+"\n";
			ui.ä�ù�1.taChatLog.append(nval);
			ui.ä�ù�1.taChatLog.setCaretPosition(ui.ä�ù�1.taChatLog.getText().length());
		}

}
