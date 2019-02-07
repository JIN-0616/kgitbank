package client;

import javax.swing.JFrame;

import client.handler.JoinActionHandler;
import client.handler.LoginActionHandler;
import client.handler.NewJoinActionHandler;
import client.panel.JoinPanel;
import client.panel.LoginPanel;

public class ClientUI extends JFrame {
	public ClientNetWorker net;
	
	public JoinPanel pnJoin;
	public LoginPanel pnLogin;
	
	public ClientUI(String ip) {
		net = new ClientNetWorker(ip, this);
		
		setUIcomponent();
		addListeners();
		
	}
	
	private void addListeners() {
		pnLogin.btLogin.addActionListener(new LoginActionHandler(this));
		pnJoin.btNewJoin.addActionListener(new JoinActionHandler(this));
		pnLogin.btJoin.addActionListener(new NewJoinActionHandler(this));
	}
	
	private void setUIcomponent() {
		pnLogin = new LoginPanel();
		pnJoin = new JoinPanel();
		
		
		setTitle("");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(400, 530);
		int rand = (int)(Math.random()*8) *30;
		setLocation(300 + rand, 200+ rand);
		
		setContentPane(pnLogin);
		
	}
}
