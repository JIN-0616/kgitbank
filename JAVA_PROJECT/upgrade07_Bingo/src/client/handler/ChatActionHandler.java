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
		
		//action�� ���� component ���� �ٸ� ���ٹ��
//		JTextField tf =(JTextField)e.getSource();
//		System.out.println(tf == ui.pnLounge.tfChat);
		
	}
}
