package ui.pregame.waitingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.network.ClientNetworkInfo;
import pregame.waitingRoom.WrGameRoomRefreshNetwork;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

public class WaitingRoomUI extends JFrame{

	public ClientNetworkInfo clientNetwork;

	public JButton btnCreateRoom;
	static int s;
	static String ip;
	public WrGameRoomDisplay ������;
	public JPanel ���������;
	public WaitingRoomChatUI ä�ù�1;
	public JLabel screenDisplay;
	private JLabel label;
	
	public PanelWU panelWU;
	
	
	public WaitingRoomUI(ClientNetworkInfo clientNetwork){
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);										//������
		
		this.clientNetwork = clientNetwork;
		init();
		System.out.println("[WAITINGROOM UI] clientNetwork " + clientNetwork.socket.isBound());
		actionListener();
		
		WrGameRoomRefreshNetwork grrn = new WrGameRoomRefreshNetwork(clientNetwork);
		grrn.sendRefreshGameroomList();

	}
	

	
	public void actionListener() {													//�׼�ó�� ���� �޼ҵ�

		btnCreateRoom.addActionListener(new ActionListener() {						//�� ���� ��ư �׼�
			public void actionPerformed(ActionEvent e) {
				new CreateRoomUI(clientNetwork).setVisible(true);					//CreatRoomUI ����
			}
		});



		addWindowListener(new WindowAdapter() {										//â ���� ����� �ý��� ����
			public void windowClosing(WindowEvent e) {
				int quit = JOptionPane.showConfirmDialog(WaitingRoomUI.this, "�����Ͻðڽ��ϱ�?");
				if (quit == JOptionPane.OK_OPTION) {
					e.getWindow().setVisible(false);
					e.getWindow().dispose();
					clientNetwork.close();
					System.exit(0);					
				} 
			}
		});

	}

	
	
	
	public void init() {
		setSize(1000,700);
		getContentPane().setLayout(null);
		
		btnCreateRoom = new JButton("");
		btnCreateRoom.setIcon(new ImageIcon("src\\image\\\uBC29\uB9CC\uB4E4\uAE302.jpg"));
		btnCreateRoom.setBounds(741, 10, 231, 36);
		getContentPane().add(btnCreateRoom);
		
		
//		������ = new WrGameRoomDisplay(clientNetwork, this);
//		������.setBounds(12, 53, 960, 360);
//		getContentPane().add(������);
		
		��������� = new WaitingRoomUserInfoUI(clientNetwork, this);
		���������.setOpaque(false);
		���������.setBounds(772, 451, 200, 200);
		getContentPane().add(���������);
		
//		
		ä�ù�1 = new WaitingRoomChatUI(clientNetwork,this);
		ä�ù�1.setOpaque(false);
		ä�ù�1.setBounds(12, 451, 580, 200);
		getContentPane().add(ä�ù�1);
		
//		
//		label = new JLabel("");
//		label.setIcon(new ImageIcon("src\\image\\\uCC44\uD305\uCC3D.jpg"));
//		label.setBounds(0, 451, 580, 200);
//		getContentPane().add(label);

		panelWU = new PanelWU();
		panelWU.setOpaque(false);
		panelWU.setBounds(604, 471, 100, 180);
		getContentPane().add(panelWU);

		JLabel lblNewLabel = new JLabel("\uC811\uC18D \uC720\uC800 \uBAA9\uB85D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(604, 451, 100, 15);
		getContentPane().add(lblNewLabel);
		
		screenDisplay = new JLabel("");
		screenDisplay.setIcon(new ImageIcon("src\\image\\\uB300\uAE30\uBC29.jpg"));
		screenDisplay.setBounds(0, 0, 984, 661);
		getContentPane().add(screenDisplay);
		
		
	}
}
