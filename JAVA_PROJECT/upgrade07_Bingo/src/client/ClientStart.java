package client;

public class ClientStart {
	public static void main(String[] args) {
		String ip = "127.0.0.1";
		ClientUI ui = new ClientUI(ip);
		ui.setVisible(true);
		
		
	}
}
