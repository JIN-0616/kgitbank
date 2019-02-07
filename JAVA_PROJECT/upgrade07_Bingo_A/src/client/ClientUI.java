package client;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.UIManager;

import client.handler.AuthActionHandler;
import client.handler.ChatActionHandler;
import client.handler.ExitActionHandler;
import client.handler.JoinActionHandler;
import client.panel.LoungePanel;
import client.panel.RoomPanel;
import client.panel.WelcomePanel;

public class ClientUI extends JFrame {
	
	public ClientNetWorker net;
	
	public WelcomePanel pnWelcome;
	public LoungePanel pnLounge;
	public RoomPanel pnRoom;
	
		
	public ClientUI(String ip) {
		/*
		 * UI�� ������Ʈ�� ����Ʈ ������ �����Ҽ� �ִ�.
		 * 	OptionPane�� �۲��� �� �۾��� ���ؼ��� �����Ҽ� �ִ�. 
		 * ���������� �⺻ Ű���� UIManager API�� �����Ѵ�.
		 */
		UIManager.put("OptionPane.font", new Font("��������ڵ�", Font.PLAIN, 12));
		UIManager.put("OptionPane.messageFont", new Font("��������ڵ�", Font.PLAIN, 12));
		UIManager.put("OptionPane.buttonFont", new Font("��������ڵ�", Font.PLAIN, 13));
		
		net = new ClientNetWorker(ip, this);
		setUIcomponent();
		addListeners();
	}

	private void addListeners() {
		pnWelcome.pfAuthPass.addActionListener(new AuthActionHandler(this));
		pnWelcome.btJoin.addActionListener(new JoinActionHandler(this));
		pnLounge.btExit.addActionListener(new ExitActionHandler(this));
		pnLounge.tfChat.addActionListener(new ChatActionHandler(this));
		
	}


	private void setUIcomponent() {
		
		
		
		pnWelcome = new WelcomePanel();
		pnLounge = new LoungePanel();
		pnRoom = new RoomPanel();
		
		
		setTitle("��Home�� - B i n g o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 375);
		int rand = (int)(Math.random()*8) *30;
		setLocation(300 + rand, 200+ rand);
		
		setContentPane(pnWelcome);
	}
}
