package ui.pregame.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import data.network.ClientNetworkInfo;

public class JoinUI extends JFrame {
	ClientNetworkInfo clientNetwork;
	LoginNetwork loginNetwork;
	
	JTextField tfId;
	JTextField tfNick;
	JLabel lblLabel1;
	JLabel lblLabel2;
	JLabel lblLabel3;
	JLabel lblLabel4;
	JPasswordField pfPass;
	JPasswordField pfPass2;
	JButton btnJoin_1;
	JLabel lblNewLabel;

	public JoinUI(ClientNetworkInfo clientNetwork) {																	//������
		this.clientNetwork = clientNetwork;
		init();
		actionListener();

	}


	public void actionListener() {
		btnJoin_1.addActionListener(new ActionListener() {												//ȸ������ ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				if (clientNetwork == null) {
					JOptionPane.showMessageDialog(null, "������ ���� ���ּ���.");
					JoinUI.this.setVisible(false);													//�޽��� ȣ�� �� â ����
					JoinUI.this.dispose();
					return;
				}
				
				if (pfPass.getText().equals(pfPass2.getText())) {
					loginNetwork = new LoginNetwork(clientNetwork);
					//��й�ȣ, ��й�ȣȮ�� ��ġ��
					Map resp = loginNetwork.sendJoin(tfId.getText(), pfPass.getText(),tfNick.getText());
					int r = (int) resp.get("result");
					if (r == 1011) {																	//������ȣ ���Ž�
						JOptionPane.showMessageDialog(JoinUI.this, "ȸ�������� �Ϸ�Ǿ����ϴ�.");
						JoinUI.this.setVisible(false);													//�޽��� ȣ�� �� â ����
						JoinUI.this.dispose();
					} else {																			//�̹� ������ ID�Ͻ�
						JOptionPane.showMessageDialog(JoinUI.this, "�̹� ���Ե� Id�Դϴ�.");
					}
				} else {
					JOptionPane.showMessageDialog(JoinUI.this, "��й�ȣ�� �������� �ʽ��ϴ�.");				//��й�ȣ, ��й�ȣȮ�� ����ġ��

				}
				
				
			}
		});
	}

	public void init() {																				//UI �ڵ�
		setSize(400, 400);
		getContentPane().setLayout(null);

		btnJoin_1 = new JButton("");
		btnJoin_1.setIcon(new ImageIcon("src\\image\\\uAC00\uC785\uD558\uAE30.jpg"));

		btnJoin_1.setBounds(134, 305, 97, 23);
		getContentPane().add(btnJoin_1);

		tfId = new JTextField();
		tfId.setBounds(193, 86, 116, 21);
		getContentPane().add(tfId);
		tfId.setColumns(10);

		tfNick = new JTextField();
		tfNick.setBounds(193, 138, 116, 21);
		getContentPane().add(tfNick);
		tfNick.setColumns(10);

		lblLabel1 = new JLabel("ID");
		lblLabel1.setBounds(95, 89, 57, 15);
		getContentPane().add(lblLabel1);

		lblLabel2 = new JLabel("NickName");
		lblLabel2.setBounds(95, 141, 74, 15);
		getContentPane().add(lblLabel2);

		lblLabel3 = new JLabel("PASSWORD");
		lblLabel3.setBounds(95, 188, 80, 15);
		getContentPane().add(lblLabel3);

		lblLabel4 = new JLabel("PW confirm");
		lblLabel4.setBounds(95, 241, 87, 15);
		getContentPane().add(lblLabel4);

		pfPass = new JPasswordField();
		pfPass.setBounds(193, 185, 116, 21);
		getContentPane().add(pfPass);

		pfPass2 = new JPasswordField();
		pfPass2.setBounds(193, 238, 116, 21);
		getContentPane().add(pfPass2);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\image\\\uC870\uC778UI.jpg"));
		lblNewLabel.setBounds(0, 0, 384, 361);
		getContentPane().add(lblNewLabel);


	}


}