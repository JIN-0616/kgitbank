package client;

public class ClientStart {
	public static void main(String[] args) {
		String ip = "192.168.10.27";
		ClientUI ui = new ClientUI(ip);
		ui.setVisible(true);
	}
}
