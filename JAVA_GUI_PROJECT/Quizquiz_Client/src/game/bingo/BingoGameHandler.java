package game.bingo;

import java.io.IOException;
import java.util.Map;

import javax.swing.JOptionPane;

import data.manager.ClientListManager;
import data.network.ClientNetworkInfo;
import data.user.User;
import pregame.waitingRoom.ClientWaitingRoomHandler;
import ui.game.bingo.BingoRoomUI;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class BingoGameHandler extends Thread {
	ClientNetworkInfo clientNetwork;
	public BingoRoomUI bingoRoomUI;

	public BingoGameHandler(ClientNetworkInfo clientNetwork, BingoRoomUI bingoRoomUI) {
		this.clientNetwork = clientNetwork;
		this.bingoRoomUI = bingoRoomUI;
	}

	// 서버 데이터 듣는 객체
	public Map responseListener(Map response) {
		try {
			response = (Map) clientNetwork.ois.readObject();
			System.out.println("[CLIENT BINGORoom DATA HANDLER] response received");
			return response;
		} catch (ClassNotFoundException | IOException e) {
			JOptionPane.showMessageDialog(bingoRoomUI, "서버와 연결이 끊겼습니다. \n 다시 로그인 해주세요");
			clientNetwork.close();
			System.exit(0);	
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
   public void run() {
      if (true) {
         Map response = null;
         while (clientNetwork.socket.isBound()) {
            System.out.println(clientNetwork.user.id + "[CLIENT BINGORoom DATA HANDLER] listening");
            response = responseListener(response);
            String mode = (String) response.get("mode");
            System.out.println("[CLIENT BINGOROOM DATA HANDLER] mode " + mode);
            switch (mode) {
            case "bingoGameAction" :
               BingoGameNetwork bgn = new BingoGameNetwork(clientNetwork, response, bingoRoomUI);
               bgn.start();
               break;
            case "gameStartTelling":
               BingoGameNetwork bgn1 = new BingoGameNetwork(clientNetwork, response, bingoRoomUI);
               bgn1.start();
               bingoRoomUI.panelBingo.addActionListener(clientNetwork, bgn1);
               break;
            case "bingoWin":
               BingoGameNetwork bgn2 = new BingoGameNetwork(clientNetwork, response, bingoRoomUI);
               bgn2.start();
               break;
            case "gameRoomUsersModified":
               BingoUserInfoNetwork buin = new BingoUserInfoNetwork(clientNetwork, response, bingoRoomUI);
               buin.start();
               break;
            case "bingoChat":
               BingoGameChatNetwork bc = new BingoGameChatNetwork(clientNetwork, response, bingoRoomUI);
               bc.start();
               break;
            case "bingoGameRoomExit":
            	BingoGameExitNetwork ben = new BingoGameExitNetwork(clientNetwork, response, bingoRoomUI, this);
				ben.start();
				break;
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
}
