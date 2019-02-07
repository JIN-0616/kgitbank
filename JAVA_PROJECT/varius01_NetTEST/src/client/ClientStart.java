package client;

public class ClientStart {
	public static void main(String[] args) {
		ClientUI ui = new ClientUI("192.168.10.27");
		
		ui.setVisible(true);
	}
}
