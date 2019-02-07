package ui.pregame.waitingRoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import data.network.ClientNetworkInfo;
import pregame.waitingRoom.CreateRoomNetwork;
import javax.swing.JTextField;

public class CreateRoomUI extends JFrame{
	
	ClientNetworkInfo clientNetwork;
	JRadioButton rdbtnCard;
	JRadioButton rdbtnBingo;
	JButton btnCreate;
	static int s;
	static String ip;
	CreateRoomNetwork createRoomNetwork;
	public JTextField tfRoomTitle;
	private JLabel label;
	
	
	
	
	public CreateRoomUI(ClientNetworkInfo clientNetwork) {																		//������
		setResizable(false);
		this.clientNetwork = clientNetwork;
		init();
		actionListener();
	}
	
	

	
	public void actionListener() {


		btnCreate.addActionListener(new ActionListener() {														//�� ���� ��ư �׼�
			public void actionPerformed(ActionEvent e) {														
				createRoomNetwork = new CreateRoomNetwork(clientNetwork);
				String title = tfRoomTitle.getText();
				if(rdbtnBingo.isSelected()) {																	//������� ����������� �׼�
					JOptionPane.showMessageDialog(CreateRoomUI.this, "��������� ���� �ϼ̽��ϴ�.");
					createRoomNetwork.sendCreate("bingo", title);
					
					//������� ���� ��ȣ ����
					CreateRoomUI.this.setVisible(false);
					CreateRoomUI.this.dispose();
				}else if(rdbtnCard.isSelected()){																//��ī����� ����������� �׼�
					JOptionPane.showMessageDialog(CreateRoomUI.this, "��ī�� ������ ���� �ϼ̽��ϴ�.");
					createRoomNetwork.sendCreate("card", title);													//��ī����� ���� ��ȣ ����
					CreateRoomUI.this.setVisible(false);
					CreateRoomUI.this.dispose();
				}
				
				
			}
		});

		addWindowListener(new WindowAdapter() {																	//â ���� ����� â�� ����
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
			}
		});

	}

	
	public void init() {																						//UI �ڵ�
		setSize(300,300);
		getContentPane().setLayout(null);
		
		JLabel lbSelectGame = new JLabel("\uAC8C\uC784 \uC120\uD0DD");
		lbSelectGame.setHorizontalAlignment(SwingConstants.CENTER);
		lbSelectGame.setBounds(51, 10, 180, 35);
		getContentPane().add(lbSelectGame);
		
		rdbtnBingo = new JRadioButton("\uBE59\uACE0\uAC8C\uC784");
		rdbtnBingo.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnBingo.setBounds(8, 74, 121, 23);
		getContentPane().add(rdbtnBingo);
		
		rdbtnCard = new JRadioButton("\uC6D0\uCE74\uB4DC");
		rdbtnCard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnCard.setEnabled(false);
		rdbtnCard.setBounds(155, 74, 121, 23);
		getContentPane().add(rdbtnCard);
		
		btnCreate = new JButton("\uBC29 \uB9CC\uB4E4\uAE30");
		btnCreate.setBounds(95, 238, 97, 23);
		getContentPane().add(btnCreate);
		
		tfRoomTitle = new JTextField();
		tfRoomTitle.setText("\uB098\uB791 \uBE59\uACE0\uAC8C\uC784 \uD55C\uD310!");
		tfRoomTitle.setBounds(12, 185, 270, 29);
		getContentPane().add(tfRoomTitle);
		tfRoomTitle.setColumns(10);
		
		label = new JLabel("\uBC29 \uC81C\uBAA9");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(95, 135, 97, 23);
		getContentPane().add(label);
	}
}
