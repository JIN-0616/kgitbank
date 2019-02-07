package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.BankClientUI;

public class BtnCreateHandler implements ActionListener {
	BankClientUI target;
	
	public BtnCreateHandler(BankClientUI target) {
		this.target =target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String resp = target.network.sendAndReceive("create");
		String[] resps = resp.split("#");
		if(resps[0].equals("true")) {
			target.lbCreate.setText("생성된 계좌아이디는 ["+ resps[1]+"] 이다.");
			target.tfId.setText(resps[1]);
			target.lbMain.setText("[SYSTEM]");
		}
	}

}
