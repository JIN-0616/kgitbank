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
				target.lbTransfer.setText("[SYSTEM] ��ü�� �� ���.");
				target.tfTarget.setText("");
				target.pfPass.setText("");
				target.tfMoney.setText("");
			}else {
				target.lbTransfer.setText("[SYSTEM] ��ü ������.(�������ġ,������,�ݾ׺���)");
			}
		}else {
			target.lbTransfer.setText("[SYSTEM] �ݾ� ������");
		}
		

	}

}
