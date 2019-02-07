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
		 * UI용 컴포넌트의 디폴트 설정을 변경할수 있다.
		 * 	OptionPane의 글꼴은 이 작업을 통해서만 설정할수 있다. 
		 * 설정가능한 기본 키값은 UIManager API를 참조한다.
		 */
		UIManager.put("OptionPane.font", new Font("나눔고딕코딩", Font.PLAIN, 12));
		UIManager.put("OptionPane.messageFont", new Font("나눔고딕코딩", Font.PLAIN, 12));
		UIManager.put("OptionPane.buttonFont", new Font("나눔고딕코딩", Font.PLAIN, 13));
		
		net = new ClientNetWorker(ip, this);
		setUIcomponent();
		addListeners();
	}

	//action 붙여야함, 객체 만들어야함
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
		/* 다른 handler 사용시
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
