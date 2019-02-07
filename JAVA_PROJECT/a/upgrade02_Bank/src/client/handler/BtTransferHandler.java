package client.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import client.BankClientUI;

public class BtTransferHandler implements ActionListener {
	BankClientUI target;
	public BtTransferHandler(BankClientUI target) {
		this.target =target;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String p = target.pfPass.getText();
		String t = target.tfTarget.getText();
		String m = target.tfMoney.getText();
		if(m.matches("\\d{1,}")) {
			String r = target.network.sendAndReceive("transfer#"+target.currentId+"#"+p+"#"+t+"#"+m);
			if(r.equals("true")) {
				target.lbTransfer.setText("[SYSTEM] 이체가 잘 됬다.");
				target.tfTarget.setText("");
				target.pfPass.setText("");
				target.tfMoney.setText("");
			}else {
				target.lbTransfer.setText("[SYSTEM] 이체 오류다.(비번불일치,대상없음,금액부족)");
			}
		}else {
			target.lbTransfer.setText("[SYSTEM] 금액 오류다");
		}
		

	}

}
