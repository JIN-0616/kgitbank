package ui.pregame.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.network.ClientNetworkInfo;
import data.user.User;
import pregame.waitingRoom.ClientWaitingRoomHandler;
import ui.pregame.waitingRoom.WaitingRoomUI;

public class LoginUI extends JFrame {
	
	public ClientNetworkInfo clientNetwork;
	
	JTextField tfId;
	JPasswordField pfPass;
	JButton btnLogin;
	JButton btnJoin;
	LoginNetwork loginNetwork;
	JButton btnPortSet;
	public int s;
	public String ip;
	private JButton btnIpSet;
	private JButton btnConnect;
	private JLabel lblNewLabel;

	public LoginUI() {																				//������
		init();
		actionListener();

	}

	void initNetwork() {																			//������ ���� �޼ҵ�
		clientNetwork = new ClientNetworkInfo(ip, s);
	}

	void executeLogin() {	
		
		if (clientNetwork == null) {
			JOptionPane.showMessageDialog(null, "������ ���� ���ּ���.");
			return;
		}
		
		
		loginNetwork = new LoginNetwork(clientNetwork);
		//�α��� �޼ҵ�
		Map resp = loginNetwork.sendLogin(tfId.getText(), pfPass.getText());
		int r = (int) resp.get("result");
		if (r == 1002) {
			JOptionPane.showMessageDialog(this, "�ش������ ���������ʽ��ϴ�. \n ȸ�������� ���ּ���");
		} else if (r == 1003) {
			JOptionPane.showMessageDialog(this, "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else if (r == 1004) {
			JOptionPane.showMessageDialog(this, "���� �α��� �Ǿ�����");
		}
		else {
			JOptionPane.showMessageDialog(LoginUI.this, "�α��ο� �����ϼ̽��ϴ�. \n ȯ���մϴ�.");
			clientNetwork.user = (User) resp.get("user");
			// WaitingRoom Handler ������ ��ŸƮ
			WaitingRoomUI waitingRoomUI = new WaitingRoomUI(clientNetwork);
			waitingRoomUI.setVisible(true);
			// User�� ���濡 �ִٰ� ǥ���Ѵ�
			clientNetwork.user.location = User.inWaitingRoom;
			
			ClientWaitingRoomHandler cWRHandler = new ClientWaitingRoomHandler(clientNetwork, waitingRoomUI);
			cWRHandler.start();
			//���� â�� ���� WaitingRoomUI ����
			LoginUI.this.setVisible(false);
//			LoginUI.this.dispose();
		}
	}

	public void actionListener() {
		btnPortSet.addActionListener(new ActionListener() {											//��Ʈ���� ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				s = Integer.parseInt(JOptionPane.showInputDialog(LoginUI.this, "������ ��Ʈ�� �Է��ϼ���"));

			}
		});
		btnIpSet.addActionListener(new ActionListener() {											//IP���� ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				ip = JOptionPane.showInputDialog(LoginUI.this, "������ IP�� �Է��ϼ���");

			}
		});
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				initNetwork();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {											//�α��� ��ư �׼�
			public void actionPerformed(ActionEvent e) {																	//������ ����
				executeLogin();																		//�α��� �޼ҵ� ����
				
			}
		});

		btnJoin.addActionListener(new ActionListener() {											//ȸ������ ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				//������ ����
				JoinUI joinUI = new JoinUI(clientNetwork);
				joinUI.setVisible(true);													//Join_UIâ ����
			}
		});

		addWindowListener(new WindowAdapter() {														//â�� ������ �����Ұ�� �ý��� ����
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});

	}

	public void init() {																			//UI �ڵ�
		setSize(1000, 700);
		getContentPane().setLayout(null);
		

		JLabel lbID = new JLabel("");
		lbID.setIcon(new ImageIcon("src\\image\\\uC544\uC774\uB514.jpg"));
		lbID.setHorizontalAlignment(SwingConstants.CENTER);
		lbID.setBounds(237, 302, 214, 42);
		getContentPane().add(lbID);

		JLabel lbpass = new JLabel("");
		lbpass.setIcon(new ImageIcon("src\\image\\PASSWORD.jpg"));
		lbpass.setHorizontalAlignment(SwingConstants.CENTER);
		lbpass.setBounds(237, 355, 214, 42);
		getContentPane().add(lbpass);

		tfId = new JTextField();
		tfId.setBounds(502, 313, 116, 21);
		getContentPane().add(tfId);
		tfId.setColumns(10);

		pfPass = new JPasswordField();
		pfPass.setBounds(502, 366, 116, 21);
		getContentPane().add(pfPass);

		btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon("src\\image\\\uB85C\uADF8\uC7781.jpg"));
		btnLogin.setBounds(502, 418, 116, 34);
		getContentPane().add(btnLogin);

		btnJoin = new JButton("");
		btnJoin.setIcon(new ImageIcon("src\\image\\\uD68C\uC6D0\uAC00\uC7852.jpg"));
		btnJoin.setBounds(297, 418, 97, 34);
		getContentPane().add(btnJoin);
		
		btnPortSet = new JButton("");
		btnPortSet.setIcon(new ImageIcon("src\\image\\\uD3EC\uD2B8\uC138\uD305.jpg"));
		btnPortSet.setBounds(815, 28, 130, 23);
		getContentPane().add(btnPortSet);
		
		btnIpSet = new JButton("");
		btnIpSet.setIcon(new ImageIcon("src\\image\\IP\uC138\uD3052.png"));
		btnIpSet.setBounds(815, 74, 130, 21);
		getContentPane().add(btnIpSet);
		
		btnConnect = new JButton("");
		btnConnect.setIcon(new ImageIcon("src\\image\\\uC811\uC18D.png"));
		btnConnect.setBounds(815, 115, 130, 21);
		getContentPane().add(btnConnect);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("src\\image\\KakaoTalk_20180604_162042878.png"));
		lblNewLabel.setBounds(0, 0, 984, 661);
		getContentPane().add(lblNewLabel);

	}
}
