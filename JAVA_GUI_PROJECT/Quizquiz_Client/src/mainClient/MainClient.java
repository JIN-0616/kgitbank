package mainClient;

import ui.pregame.login.LoginUI;

public class MainClient {
	public static LoginUI startClient;
	
	public static void main(String[] args) {
		startClient = new LoginUI();
		startClient.ip = "192.168.10.44";
		startClient.s = 45678;
		startClient.setVisible(true);	
	}
}
