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

	public LoginUI() {																				//생성자
		init();
		actionListener();

	}

	void initNetwork() {																			//서버와 연결 메소드
		clientNetwork = new ClientNetworkInfo(ip, s);
	}

	void executeLogin() {	
		
		if (clientNetwork == null) {
			JOptionPane.showMessageDialog(null, "접속을 먼저 해주세요.");
			return;
		}
		
		
		loginNetwork = new LoginNetwork(clientNetwork);
		//로그인 메소드
		Map resp = loginNetwork.sendLogin(tfId.getText(), pfPass.getText());
		int r = (int) resp.get("result");
		if (r == 1002) {
			JOptionPane.showMessageDialog(this, "해당계정이 존재하지않습니다. \n 회원가입을 해주세요");
		} else if (r == 1003) {
			JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다.");
		} else if (r == 1004) {
			JOptionPane.showMessageDialog(this, "벌써 로그인 되어있음");
		}
		else {
			JOptionPane.showMessageDialog(LoginUI.this, "로그인에 성공하셨습니다. \n 환영합니다.");
			clientNetwork.user = (User) resp.get("user");
			// WaitingRoom Handler 쓰레드 스타트
			WaitingRoomUI waitingRoomUI = new WaitingRoomUI(clientNetwork);
			waitingRoomUI.setVisible(true);
			// User가 대기방에 있다고 표시한다
			clientNetwork.user.location = User.inWaitingRoom;
			
			ClientWaitingRoomHandler cWRHandler = new ClientWaitingRoomHandler(clientNetwork, waitingRoomUI);
			cWRHandler.start();
			//기존 창을 끄고 WaitingRoomUI 실행
			LoginUI.this.setVisible(false);
//			LoginUI.this.dispose();
		}
	}

	public void actionListener() {
		btnPortSet.addActionListener(new ActionListener() {											//포트설정 버튼 액션
			public void actionPerformed(ActionEvent e) {
				s = Integer.parseInt(JOptionPane.showInputDialog(LoginUI.this, "설정할 포트를 입력하세요"));

			}
		});
		btnIpSet.addActionListener(new ActionListener() {											//IP설정 버튼 액션
			public void actionPerformed(ActionEvent e) {
				ip = JOptionPane.showInputDialog(LoginUI.this, "설정할 IP를 입력하세요");

			}
		});
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				initNetwork();
			}
		});
		
		btnLogin.addActionListener(new ActionListener() {											//로그인 버튼 액션
			public void actionPerformed(ActionEvent e) {																	//서버와 연결
				executeLogin();																		//로그인 메소드 실행
				
			}
		});

		btnJoin.addActionListener(new ActionListener() {											//회원가입 버튼 액션
			public void actionPerformed(ActionEvent e) {
				//서버와 연결
				JoinUI joinUI = new JoinUI(clientNetwork);
				joinUI.setVisible(true);													//Join_UI창 띄우기
			}
		});

		addWindowListener(new WindowAdapter() {														//창을 강제로 종료할경우 시스템 종료
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			}
		});

	}

	public void init() {																			//UI 코드
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
