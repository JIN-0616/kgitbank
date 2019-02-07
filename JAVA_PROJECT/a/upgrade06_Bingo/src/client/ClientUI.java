package client;

import javax.swing.JFrame;

import client.panel.WelcomePanel;

public class ClientUI extends JFrame {
	WelcomePanel pnWelcome;
	
	
	public ClientUI() {
		setUIcomponent();
		addListeners();
	}


	private void addListeners() {
		pnWelcome.pfAuthPass.addActionListener(null);
		pnWelcome.btJoin.addActionListener(null);
	}


	private void setUIcomponent() {
		pnWelcome = new WelcomePanel();
		
		
		setTitle("BINGO,BINGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(500, 375);
		int rand = (int)(Math.random()*8) *30;
		setLocation(300 + rand, 200+ rand);
		
		setContentPane(pnWelcome);
	}
}
