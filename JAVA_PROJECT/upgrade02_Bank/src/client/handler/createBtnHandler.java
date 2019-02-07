package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import clientGUI.BankClientUI;

public class createBtnHandler implements ActionListener {
	BankClientUI ui;
	public createBtnHandler(BankClientUI ui) {
		this.ui=ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String rep = ui.net.sendAndReceive("create");
		String[] resp = rep.split("#");
		if (resp[0].equals("true")) {
			ui.lblNewLabel_5.setText("생성된 계좌아이디는 ["+ resp[1]+"] 이다.");
			ui.textField.setText(resp[1]);
			ui.lblNewLabel_1.setText("input enter");
		}
	}

}
