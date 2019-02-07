package ui.pregame.waitingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

//import ui.pregame.login.Login_Network;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.network.ClientNetworkInfo;
import pregame.waitingRoom.WaitingRoomChatNetwork;

public class WaitingRoomChatUI extends JPanel {

	public JTextField tfChat;
	public JScrollPane scrollPane;
	public JTextArea taChatLog;
	WaitingRoomUI waitingRoomUI;
	public JButton btnSend;
	ClientNetworkInfo clientNetwork;

	public WaitingRoomChatUI(ClientNetworkInfo net, WaitingRoomUI waitingRoomUI) {
		clientNetwork = net;
		this.waitingRoomUI = waitingRoomUI;
		init();
		addEventHandler();

	}

	public void addEventHandler() {
		tfChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tfChat.getText();
				if (txt.trim().length() != 0) {
					WaitingRoomChatNetwork net = new WaitingRoomChatNetwork(clientNetwork, null, null);
					net.sendChat(txt);
				}
				tfChat.setText("");
			}
		});

		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tfChat.getText();
				if (txt.trim().length() != 0) {
					WaitingRoomChatNetwork net = new WaitingRoomChatNetwork(clientNetwork, null, null);
					net.sendChat(txt);
				}
				tfChat.setText("");
			}
		});
	}

	public void init() {
		setSize(600, 200);
		setLayout(null);

		tfChat = new JTextField();
		tfChat.setBounds(12, 169, 457, 20);
		add(tfChat);
		tfChat.setColumns(10);

		btnSend = new JButton("\uBCF4\uB0B4\uAE30");
		btnSend.setBounds(481, 168, 90, 20);
		add(btnSend);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 560, 150);
		add(scrollPane);

		taChatLog = new JTextArea();
		taChatLog.setEditable(false);
		add(taChatLog);
//		scrollPane.add(taChatLog);
		scrollPane.setViewportView(taChatLog);

	}
	// public static void main(String[] args) {
	// JFrame f = new JFrame();
	// f.setSize(1000, 1000);
	//
	// WaitingRoomChatUI ui = new WaitingRoomChatUI();;
	// f.add(ui);
	//
	// f.setVisible(true);
	// }
}
