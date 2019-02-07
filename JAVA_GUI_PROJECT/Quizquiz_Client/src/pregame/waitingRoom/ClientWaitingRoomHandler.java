package pregame.waitingRoom;

import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import data.network.ClientNetworkInfo;
import data.user.User;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class ClientWaitingRoomHandler extends Thread {
	ClientNetworkInfo clientNetwork;
	WaitingRoomUI waitingRoomUI;
	
	ClientWaitingRoomHandlerThread cwrhThread;

	public ClientWaitingRoomHandler(ClientNetworkInfo clientNetwork, WaitingRoomUI waitingRoomUI) {
		this.clientNetwork = clientNetwork;
		this.waitingRoomUI = waitingRoomUI;
	}
	
	
	// ���� ������ ��� ��ü
	private Map responseListener(Map response) {
		try {
			response = (Map)clientNetwork.ois.readObject();
			System.out.println("[CLIENT WAITINGRoom DATA HANDLER] response received");
			return response;
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(waitingRoomUI, "������ ������ ������ϴ�. \n �ٽ� �α��� ���ּ���");
			clientNetwork.close();
			System.exit(0);	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	// ������ ó��
	@Override
	public void run() {
		if (true) {
			Map response = null;
			while (clientNetwork.socket.isBound()) {
				System.out.println(clientNetwork.user.id + "[CLIENT WAITINGRoom DATA HANDLER] listening");
				response = responseListener(response);
				String mode = (String)response.get("mode");
				System.out.println("[CLIENT WAITINGROOM DATA HANDLER] mode " + mode);
				switch(mode) {
				case "joinGameRoom":
					WrGameRoomJoinNetwork gjn = new WrGameRoomJoinNetwork(clientNetwork, response, waitingRoomUI);
					gjn.gameRoomJoin(response);
					if (clientNetwork.user.location == User.inGameRoom) {
						Thread.currentThread().stop();						
					}
					break;
				case "createGameRoom":
					CreateRoomNetwork crn = new CreateRoomNetwork(clientNetwork, response, waitingRoomUI);
					crn.createRoom(response);
					if (clientNetwork.user.location == User.inGameRoom) {
						Thread.currentThread().stop();						
					}
	                break;
				default:
					cwrhThread = new ClientWaitingRoomHandlerThread(clientNetwork, response, waitingRoomUI);
					cwrhThread.start();
					break;
				}
				
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
