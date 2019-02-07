package client;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;

import client.handler.AuthPassHandler;
import client.handler.ChatActionHandler;
import client.handler.ExitActionHandler;
import client.handler.JoinHandler;
import client.handler.LeaveActionHandler;
import client.handler.EnterActionHandler;
import client.handler.radioButtonHandler;
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

	//action �ٿ�����, ��ü ��������
	private void addListeners() {
		pnWelcome.pfAuthPass.addActionListener(new AuthPassHandler(this));
		pnWelcome.btJoin.addActionListener(new JoinHandler(this));
		pnWelcome.rbtAgree.addItemListener(new radioButtonHandler(this));
		pnWelcome.rbtDisagree.addItemListener(new radioButtonHandler(this));		
		pnLounge.btExit.addActionListener(new ExitActionHandler(this));
		pnLounge.tfChat.addActionListener(new ChatActionHandler(this));
		for (int i = 0; i < 9; i++) {
			pnLounge.rbts.get(i).addActionListener(new EnterActionHandler(this));
		}
		pnRoom.btLeave.addActionListener(new LeaveActionHandler(this));
		/*
		 * for(JButton b : pnLounge.rbts){
		 * 		b.addActionListener(new EnterActionHandler(this));
		 * }
		 */
		/*
		 * pnLounge.rbts.get(0).addActionListener(new EnterZeroActionHandler(this));
		 * pnLounge.rbts.get(1).addActionListener(new EnterOneActionHandler(this));
		 */
		/* �ٸ� handler ����
		 * for(int i=0; i<pnLounge.rbts.size(); i++) {
		 * 	  pnLounge.rbts.get(i).addActionListener(new EnterRoomActionHandler(this, i));
		 * 
		 * }
		 */
		
		
	}


	private void setUIcomponent() {
		pnWelcome = new WelcomePanel();
		pnLounge = new LoungePanel();
		pnRoom = new RoomPanel();			
		
		setTitle("BINGO,BINGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 375);
		int rand = (int)(Math.random()*8) *30;
		setLocation(300 + rand, 200+ rand);
		pnWelcome.btJoin.setEnabled(false);
		setContentPane(pnWelcome);
	}
}
