package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import client.ClientUI;

public class ChatActionHandler implements ActionListener {
	ClientUI ui;
	public ChatActionHandler(ClientUI clientUI) {
		ui = clientUI;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = ui.pnLounge.tfChat.getText();
		if(msg.contains("#")) {
			JOptionPane.showMessageDialog(ui, "�޼����� # �� ������ ����");
		}else {
			ui.net.sendChatRequest(msg);
			ui.pnLounge.tfChat.setText("");
		}
	//	JTextField tf =(JTextField)e.getSource();
	//	System.out.println(tf == ui.pnLounge.tfChat);
		
		
	}

}
