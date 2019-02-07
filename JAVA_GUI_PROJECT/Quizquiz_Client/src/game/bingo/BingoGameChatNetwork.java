package game.bingo;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

import data.network.ClientNetworkInfo;
import ui.game.bingo.BingoRoomUI;

public class BingoGameChatNetwork extends Thread {
	ClientNetworkInfo net;
	BingoRoomUI ui;
	Map response;
	//

	public BingoGameChatNetwork(ClientNetworkInfo clientNetwork, Map response, BingoRoomUI ui) {
		net = clientNetwork;
		this.response = response;
		this.ui = ui;
	}

	public void sendChat2(String message) {
		Map request = new Hashtable<>();
		request.put("mode", "bingoChat");
		request.put("message", message);
		try {
			net.oos.writeObject(request);
		} catch (IOException e) {
			e.printStackTrace();
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
		String message = (String) response.get("message");
		String talker = (String) response.get("talker");
		System.out.println("message");
		String nval = "[" + talker + "] " + message + "\n";
		ui.panelChat.taChatLog2.append(nval);
		ui.panelChat.taChatLog2.setCaretPosition(ui.panelChat.taChatLog2.getText().length());
		// ��ũ������ �ǳ��ٷ� �����°�
	}
}
