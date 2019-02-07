package clientGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import client.handler.btnHandler;
import client.handler.createBtnHandler;
import client.handler.txtFieldHandler;

public class BankClientUI extends JFrame{
	public String id;
	public BankClientNetwork net;
	
	public JTextField textField_2;
	public JTextField textField_4;
	public JTextField textField_5;
	public JTextField textField_6;
	public JTextField textField;
	public JLabel lblNewLabel_1;
	public JButton btnCreate;
	public JLabel lblNewLabel_2;
	public JLabel lblNewLabel_4;
	public JButton tranferButton;
	public JLabel lblNewLabel_5;
	public JTabbedPane tabbedPane;
	public BankClientUI() {
		net = new BankClientNetwork("127.0.0.1");
		init();
		addActionListener();		
		
	}
	void addActionListener(){
		btnCreate.addActionListener(new createBtnHandler(this));
		tranferButton.addActionListener(new btnHandler(this));
		textField_2.addActionListener(new txtFieldHandler(this));
	}
	
	void init() {
		setTitle("BankClient");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 10, 410, 241);
		getContentPane().add(tabbedPane);
		
		JPanel panel_id = new JPanel();
		tabbedPane.addTab("  ID  ", null, panel_id, null);
		tabbedPane.setEnabledAt(0, true);
		panel_id.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(30, 129, 116, 21);
		panel_id.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID\uB97C \uC785\uB825\uD558\uAC70\uB098 \uC0DD\uC131\uD558\uBA74 \uC11C\uBE44\uC2A4\uB97C \uC774\uC6A9\uD560\uC218 \uC788\uC2B5\uB2C8\uB2E4");
		lblNewLabel.setBounds(30, 83, 295, 15);
		panel_id.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("BankServer Connected");
		lblNewLabel_1.setBounds(30, 171, 129, 15);
		panel_id.add(lblNewLabel_1);
		
		JPanel panel_create = new JPanel();
		tabbedPane.addTab("∞Ë¡¬ ª˝º∫", null, panel_create, null);
		tabbedPane.setEnabledAt(1, true);
		panel_create.setLayout(null);
		
		btnCreate = new JButton("create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreate.setBounds(104, 93, 97, 23);
		panel_create.add(btnCreate);
		
		lblNewLabel_5 = new JLabel("\uBC84\uD2BC\uC744 \uB204\uB974\uBA74 \uACC4\uC88C\uAC00 \uC0DD\uC131\uB429\uB2C8\uB2E4.");
		lblNewLabel_5.setBounds(105, 58, 184, 15);
		panel_create.add(lblNewLabel_5);
		
		JPanel panel_get = new JPanel();
		tabbedPane.addTab("∞Ë¡¬ »Æ¿Œ", null, panel_get, null);
		tabbedPane.setEnabledAt(2, false);
		panel_get.setLayout(null);
		
		textField_2 = new JTextField();

		textField_2.setBounds(12, 113, 116, 21);
		panel_get.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PW");
		lblNewLabel_3.setBounds(12, 88, 57, 15);
		panel_get.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("\uACC4\uC88C\uD655\uC778 \uC11C\uBE44\uC2A4");
		lblNewLabel_2.setBounds(179, 116, 88, 15);
		panel_get.add(lblNewLabel_2);
		
		JPanel panel_transfer = new JPanel();
		tabbedPane.addTab("∞Ë¡¬ ¿Ã√º", null, panel_transfer, null);
		tabbedPane.setEnabledAt(3, false);
		panel_transfer.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(12, 91, 116, 21);
		panel_transfer.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(12, 147, 116, 21);
		panel_transfer.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("PW");
		lblNewLabel_7.setBounds(12, 66, 57, 15);
		panel_transfer.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("\uC0C1\uB300\uBC29 ID");
		lblNewLabel_8.setBounds(12, 122, 57, 15);
		panel_transfer.add(lblNewLabel_8);
		
		lblNewLabel_4 = new JLabel("\uACC4\uC88C\uC774\uCCB4 \uC11C\uBE44\uC2A4\uC785\uB2C8\uB2E4");
		lblNewLabel_4.setBounds(179, 66, 124, 15);
		panel_transfer.add(lblNewLabel_4);
		
		textField_6 = new JTextField();
		textField_6.setBounds(179, 147, 116, 21);
		panel_transfer.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label = new JLabel("\uC774\uCCB4 \uAE08\uC561");
		label.setBounds(179, 122, 57, 15);
		panel_transfer.add(label);
		
		tranferButton = new JButton("\uC774\uCCB4");

		tranferButton.setBounds(179, 90, 97, 23);
		panel_transfer.add(tranferButton);
	}
}
