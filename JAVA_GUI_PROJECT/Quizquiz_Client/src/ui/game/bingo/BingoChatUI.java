package ui.game.bingo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import data.network.ClientNetworkInfo;
import game.bingo.BingoGameChatNetwork;

public class BingoChatUI extends JPanel {
	public JTextField tfChat2;
	public JScrollPane scrollPane2;
	public JTextArea taChatLog2;
	public BingoRoomUI bingoRoomUI;
	public JButton btnSend2;
	public ClientNetworkInfo clientNetwork;

	public BingoChatUI(ClientNetworkInfo net, BingoRoomUI bingoRoomUI) {
		clientNetwork = net;
		this.bingoRoomUI = bingoRoomUI;
		init();
		addEventHandler();
	}
	public void addEventHandler() {
		tfChat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tfChat2.getText();
				if (txt.trim().length() != 0) {
					BingoGameChatNetwork net = new BingoGameChatNetwork(clientNetwork, null, null);
					net.sendChat2(txt);
				}
				tfChat2.setText("");
			}
		});

		btnSend2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String txt = tfChat2.getText();
				if (txt.trim().length() != 0) {
					BingoGameChatNetwork net = new BingoGameChatNetwork(clientNetwork, null, null);
					net.sendChat2(txt);
				}
				tfChat2.setText("");
			}
		});
	}


	public void init() {
		setSize(463, 200);
		setLayout(null);

		tfChat2 = new JTextField();
		tfChat2.setBounds(17, 158, 305, 27);
		add(tfChat2);
		tfChat2.setColumns(10);

		btnSend2 = new JButton("\uC804\uC1A1");
		btnSend2.setBounds(339, 157, 107, 29);
		add(btnSend2);

		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(17, 15, 429, 135);
		add(scrollPane2);

		taChatLog2 = new JTextArea();
		taChatLog2.setEditable(false);
		add(taChatLog2);
		scrollPane2.setViewportView(taChatLog2);

	}
}

