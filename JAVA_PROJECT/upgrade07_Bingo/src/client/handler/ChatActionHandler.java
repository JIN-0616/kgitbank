package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.ClientUI;

public class ChatActionHandler implements ActionListener {
	ClientUI ui;
	public ChatActionHandler(ClientUI ui) {
		this.ui = ui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String mylog = ui.pnLounge.tfChat.getText();
		ui.net.sendChatLog(mylog);	
		ui.pnLounge.tfChat.setText("");
		
		//action을 붙인 component 로의 다른 접근방법
//		JTextField tf =(JTextField)e.getSource();
//		System.out.println(tf == ui.pnLounge.tfChat);
		
	}
}
