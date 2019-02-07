package client;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import client.handler.MoveHandler;

public class ClientUI extends JFrame {

	public ClientNetwork net;
	
	public JLabel[][] lbs;
	
	public ClientUI(String ip) {
		
		UIManager.put("OptionPane.font", new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		UIManager.put("OptionPane.messageFont", new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 12));
		UIManager.put("OptionPane.buttonFont", new Font("³ª´®°íµñÄÚµù", Font.PLAIN, 13));
		
		setSize(650, 480);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 10, 420, 420);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(30, 30, 2, 2));
			
		JLabel lbProfile = new JLabel(new ImageIcon(ClassLoader.getSystemResource("resource/screen.jpg")));
		lbProfile.setBounds(444, 10, 150, 225);
		getContentPane().add(lbProfile);
		
		lbs= new JLabel[30][30];
		
		for(int r=0; r<30; r++) {
			for(int c=0; c<30; c++) {
				lbs[r][c] = new JLabel();
				lbs[r][c].setBackground(Color.LIGHT_GRAY);
				lbs[r][c].setOpaque(true);
				panel.add(lbs[r][c]);
			}
		}
		this.addKeyListener(new MoveHandler(this));
		
		
		
		net = new ClientNetwork(ip, this);
	}
	
}
